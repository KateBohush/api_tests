package de.fidor.testdata.converters.authservice;

import com.google.gson.Gson;
import de.fidor.dal.datamodels.authservice.GetTokenRequest;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

public class GetTokenRequestConverter extends AbstractConverter<GetTokenRequest> {

    @Override
    public GetTokenRequest convert(Map<String, Object> convertFrom) {
        GetTokenRequest getTokenRequest = null;

        if (convertFrom != null) {
            Gson gson = new Gson();
            getTokenRequest = gson.fromJson((String) convertFrom.get("request"), GetTokenRequest.class);
        }

        return getTokenRequest;
    }
}
