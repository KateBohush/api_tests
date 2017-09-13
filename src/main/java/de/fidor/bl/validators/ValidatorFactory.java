package de.fidor.bl.validators;

import de.fidor.dal.datamodels.infrastructure.ResponseWithData;

public class ValidatorFactory {

    public static AuthServiceValidator getAuthServiceValidator(ResponseWithData response){
        return new AuthServiceValidator(response);
    }
}
