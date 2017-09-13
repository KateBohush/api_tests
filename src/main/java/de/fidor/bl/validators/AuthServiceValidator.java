package de.fidor.bl.validators;

import de.fidor.dal.datamodels.authservice.GetTokenResponse;
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
        compare(expectedResult, actualEntity);
        Assert.assertTrue(actualEntity.getAccess_token() != null);
        Assert.assertTrue(actualEntity.getRefresh_token() != null);
    }
}
