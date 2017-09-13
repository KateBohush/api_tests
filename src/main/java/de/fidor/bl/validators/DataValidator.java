package de.fidor.bl.validators;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.fidor.dal.datamodels.infrastructure.DiffResult;
import de.fidor.dal.datamodels.infrastructure.GherkinTestCase;
import de.fidor.dal.datamodels.infrastructure.ResponseWithData;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DataValidator {

    private Map<Class<?>, String[]> ignoreProps;

    protected ResponseWithData response;

    public DataValidator(ResponseWithData response) {
        this.response = response;
    }

    public void setIgnoreProps(Class<?> obj, String... fieldsToIgnore) {
        if (fieldsToIgnore != null) {
            HashMap<Class<?>, String[]> fieldsToIgnoreMap = new HashMap<>();
            List<String> list = Arrays.asList(fieldsToIgnore);
            fieldsToIgnoreMap.put(obj, list.toArray(new String[list.size()]));
            ignoreProps = fieldsToIgnoreMap;
        }
    }

    protected void validateStatusCode(int expectedCode) {
        int actualCode = response.getHttpFullResponse().getStatusCode();
        Assert.assertEquals("!!!Status Code Verification Failed!!! expected code = "
                + expectedCode + "; actual code = " + actualCode, expectedCode, actualCode);
    }

    public DiffResult compare(Object exp, Object act) {

        ObjectDifferBuilder differBuilder = ObjectDifferBuilder.startBuilding();

        if (ignoreProps != null) {
            ignoreProps.keySet()
                    .forEach(c -> differBuilder.inclusion().exclude().propertyNameOfType(c, ignoreProps.get(c)));
        }

        DiffNode diffs = differBuilder.build().compare(act, exp);
        DiffResult result = new DiffResult();

        if (diffs.getState() != DiffNode.State.UNTOUCHED) {
            StringBuilder differences = new StringBuilder();
            diffs.visit((node, visit) -> {
                if (node.childCount() == 0) {
                    Object was = node.canonicalGet(exp);
                    Object became = node.canonicalGet(act);
                    differences.append(node.getPath() + " => "
                            + node.getState() + " ( expected: " + was + ", but found actual: " + became + " )\n");
                }
            });
            result.diffs = differences.toString();
            System.out.println(diffs);
            result.diffState = diffs.getState();
        } else {
            result.diffState = diffs.getState();
        }
        return result;
    }
}
