package de.fidor.bl.validators;

import de.danielbechler.diff.node.DiffNode;
import de.fidor.dal.datamodels.authservice.GetTokenResponse;
import de.fidor.dal.datamodels.infrastructure.DiffResult;
import de.fidor.dal.datamodels.infrastructure.ResponseWithData;
import org.junit.Assert;

public class AuthServiceValidator extends DataValidator {

    public AuthServiceValidator(ResponseWithData response) {
        super(response);
    }

    public void verifyTokenWasReturned(GetTokenResponse expectedResult) {
        validateStatusCode(200);
        setIgnoreProps(GetTokenResponse.class, "access_token", "refresh_token");
        GetTokenResponse actualEntity = (GetTokenResponse) response.getResponseEntity();
        Assert.assertEquals("Actual result differs from expected",
                DiffNode.State.UNTOUCHED, compare(expectedResult, actualEntity).getDiffState());
        Assert.assertTrue(actualEntity.getAccess_token() != null);
        Assert.assertTrue(actualEntity.getRefresh_token() != null);
    }
}
