package de.fidor.testdata.converters;

import com.google.gson.Gson;
import org.easetech.easytest.converter.AbstractConverter;
import ru.yandex.qatools.allure.annotations.Parameter;

import java.util.Map;

public class TestCaseConverter extends AbstractConverter<GherkinTestCase> {

    @Parameter("given")
    String given;

    @Parameter("when")
    String when;

    @Parameter("then")
    String then;

    @Override
    public GherkinTestCase convert(Map<String, Object> convertFrom) {
        GherkinTestCase testCase = null;

        if (convertFrom != null) {
            Gson gson = new Gson();
            testCase = gson.fromJson((String) convertFrom.get("testcase"), GherkinTestCase.class);
        }
        addTestCaseToReport(testCase);
        return testCase;
    }

    protected void addTestCaseToReport(GherkinTestCase testCase){
        given = testCase.getGiven();
        when = testCase.getWhen();
        then = testCase.getThen();
    }
}
