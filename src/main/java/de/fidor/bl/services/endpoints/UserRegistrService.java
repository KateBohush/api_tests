package de.fidor.bl.services.endpoints;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import de.fidor.bl.services.ServiceFactory;
import de.fidor.dal.datamodels.infrastructure.ResponseWithData;
import de.fidor.dal.datamodels.userregistrservice.GetTokenCredentialsResponse;
import de.fidor.dal.datamodels.userregistrservice.RegistrationResponse;

public class UserRegistrService extends ServiceFactory {

    public ResponseWithData getTokenCredentials() {
        Header[] headers = {
                new Header("Accept", "application/json"),
                new Header("Content-Type", "application/json"),
                new Header("Authorization", "Basic NDY2OGIxMDY3NjU0NWY2MDphZDI4M2M5YjA2MzdjZTc3ZjE5Y2U2N2YyMjIxZTM0Nw==")
        };
        ResponseWithData<GetTokenCredentialsResponse> response = new ResponseWithData<>();

        Response resp = getClient().post(env + "/oauth/token", ContentType.JSON, "{\"grant_type\": \"client_credentials\"}", headers);
        response.setHttpFullResponse(resp);
        response.setResponseEntity(resp.getBody().as(GetTokenCredentialsResponse.class));

        return response;
    }


    public ResponseWithData register(String body) {
        GetTokenCredentialsResponse credentialsResponse =(GetTokenCredentialsResponse) getTokenCredentials().getResponseEntity();

        Header[] headers = {
                new Header("Authorization", credentialsResponse.getToken_type() + " " + credentialsResponse.getAccess_token()),
                new Header("Accept", "application/vnd.fidor.de; version=1,text/json"),
                new Header("Content-Type", "application/json"),
                new Header("Cache-Control", "No-Cache")
        };
        ResponseWithData<RegistrationResponse> response = new ResponseWithData<>();

        Response resp = getClient().post(env + "/fidor_api/customers", ContentType.JSON, body, headers);
        response.setHttpFullResponse(resp);
        response.setResponseEntity(resp.getBody().as(RegistrationResponse.class));

        return response;
    }


}
