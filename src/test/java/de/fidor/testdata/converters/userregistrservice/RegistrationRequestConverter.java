package de.fidor.testdata.converters.userregistrservice;

import com.google.gson.Gson;
import de.fidor.dal.datamodels.userregistrservice.RegistrationRequest;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

public class RegistrationRequestConverter extends AbstractConverter<RegistrationRequest> {
    @Override
    public RegistrationRequest convert(Map<String, Object> convertFrom) {
        RegistrationRequest registrationRequest = null;

        if (convertFrom != null) {
            Gson gson = new Gson();
            registrationRequest = gson.fromJson((String) convertFrom.get("request"), RegistrationRequest.class);
        }

        return registrationRequest;
    }
}
