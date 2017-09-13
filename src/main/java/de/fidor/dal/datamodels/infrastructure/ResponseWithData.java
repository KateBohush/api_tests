package de.fidor.dal.datamodels.infrastructure;

import com.jayway.restassured.response.Response;
import lombok.Data;
import org.junit.Assert;

@Data
public class ResponseWithData<T> {
    private Response httpFullResponse;
    private T responseEntity;

    public ResponseWithData<T> validateResponseStatusCode(int code) {
        Assert.assertEquals("Status Code Failed", code, httpFullResponse.getStatusCode());
        return this;
    }
}
