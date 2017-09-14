package de.fidor.testdata.converters.userregistrservice;

import com.google.gson.Gson;
import de.fidor.dal.datamodels.userregistrservice.RegistrationResponse;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

public class RegistrationResponseConverter extends AbstractConverter<RegistrationResponse> {

    @Override
    public RegistrationResponse convert(Map<String, Object> convertFrom) {
        RegistrationResponse registrationResponse = null;

        if (convertFrom != null) {
            Gson gson = new Gson();
            registrationResponse = gson.fromJson((String) convertFrom.get("expected_response"), RegistrationResponse.class);
        }

        return registrationResponse;
    }
}
