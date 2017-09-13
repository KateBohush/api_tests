package de.fidor.testdata.converters.authservice;

import com.google.gson.Gson;
import de.fidor.dal.datamodels.authservice.GetTokenRequest;
import de.fidor.dal.datamodels.authservice.GetTokenResponse;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

public class GetTokenExpectedResponseConverter extends AbstractConverter<GetTokenResponse> {
    @Override
    public GetTokenResponse convert(Map<String, Object> convertFrom) {
        GetTokenResponse getTokenExpectedResponse = null;

        if (convertFrom != null) {
            Gson gson = new Gson();
            getTokenExpectedResponse = gson.fromJson((String) convertFrom.get("expected_response"), GetTokenResponse.class);
        }

        return getTokenExpectedResponse;
    }
}
