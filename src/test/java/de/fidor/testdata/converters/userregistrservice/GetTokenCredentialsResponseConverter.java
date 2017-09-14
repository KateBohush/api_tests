package de.fidor.testdata.converters.userregistrservice;

import com.google.gson.Gson;
import de.fidor.dal.datamodels.userregistrservice.GetTokenCredentialsResponse;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

public class GetTokenCredentialsResponseConverter extends AbstractConverter<GetTokenCredentialsResponse> {
    public GetTokenCredentialsResponse convert(Map<String, Object> convertFrom) {
        GetTokenCredentialsResponse getTokenCredentialsResponse = null;

        if (convertFrom != null) {
            Gson gson = new Gson();
            getTokenCredentialsResponse = gson.fromJson((String) convertFrom.get("request"), GetTokenCredentialsResponse.class);
        }

        return getTokenCredentialsResponse;
    }
}
