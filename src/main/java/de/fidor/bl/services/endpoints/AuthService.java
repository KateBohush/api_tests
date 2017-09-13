package de.fidor.bl.services.endpoints;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import de.fidor.bl.services.ServiceFactory;
import de.fidor.dal.datamodels.authservice.GetTokenResponse;
import de.fidor.dal.datamodels.infrastructure.ResponseWithData;

public class AuthService extends ServiceFactory {

    public ResponseWithData getTokenUsingPassword(String body) {
        Header[] headers = {
                new Header("Authorization", "Basic NDY2OGIxMDY3NjU0NWY2MDphZDI4M2M5YjA2MzdjZTc3ZjE5Y2U2N2YyMjIxZTM0Nw=="),
                new Header("Accept", "application/json")
        };
        ResponseWithData<GetTokenResponse> response = new ResponseWithData<>();

        Response resp = getClient().post(env + "/oauth/token", ContentType.JSON, body, headers);
        response.setHttpFullResponse(resp);
        response.setResponseEntity(resp.getBody().as(GetTokenResponse.class));

        return response;
    }
}
