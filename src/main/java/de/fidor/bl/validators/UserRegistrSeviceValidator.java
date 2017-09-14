package de.fidor.bl.validators;

import de.danielbechler.diff.node.DiffNode;
import de.fidor.dal.datamodels.authservice.GetTokenRequest;
import de.fidor.dal.datamodels.infrastructure.ResponseWithData;
import de.fidor.dal.datamodels.userregistrservice.RegistrationResponse;
import org.junit.Assert;

public class UserRegistrSeviceValidator extends DataValidator {
    public UserRegistrSeviceValidator(ResponseWithData response) {super(response);}

    public void verifyUserWasRegistered(RegistrationResponse expectedResult) {
        validateStatusCode(200);
        setIgnoreProps(GetTokenRequest.class,"id","affiliate_uid","created_at","updated_at");
        RegistrationResponse actualEntity = (RegistrationResponse) response.getResponseEntity();

        Assert.assertEquals("Actual result differs from expected",
                DiffNode.State.UNTOUCHED, compare(expectedResult, actualEntity).getDiffState());

    }
}
