package de.fidor.core;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.given;

public class RestClient {

    private String token;
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    private Header getAuthBearerHeader() {
        if (token != null) {
            return new Header("Authorization", "Bearer " + token);
        }
        return null;
    }

    public Response post(String url, ContentType contentType, Object body, Header... headers) {
        RequestSpecification requestSpecification = given().
                contentType(contentType);

        if (getAuthBearerHeader() != null)
            requestSpecification.header(getAuthBearerHeader());

        if (headers != null && headers.length > 0)
            Arrays.stream(headers).forEach(h -> requestSpecification.header(h));

        response = requestSpecification.body(body)
                .when().post(url)
                .then()
                .extract().response();

        return response;
    }


    public Response put(String url, ContentType contentType, Object body, Header... headers) {
        RequestSpecification requestSpecification = given().
                contentType(contentType);

        if (getAuthBearerHeader() != null)
            requestSpecification.header(getAuthBearerHeader());

        if (headers != null && headers.length > 0)
            Arrays.stream(headers).forEach(h -> requestSpecification.header(h));

        response = requestSpecification.body(body)
                .when().put(url)
                .then()
                .extract().response();

        return response;
    }

    public Response patch(String url, ContentType contentType, Object body, Header... headers) {
        RequestSpecification requestSpecification = given().
                contentType(contentType);

        if (getAuthBearerHeader() != null)
            requestSpecification.header(getAuthBearerHeader());

        if (headers != null && headers.length > 0)
            Arrays.stream(headers).forEach(h -> requestSpecification.header(h));

        response = requestSpecification.body(body)
                .when().patch(url)
                .then()
                .extract().response();

        return response;
    }

    public Response get(String url, ContentType contentType, Header... headers) {
        RequestSpecification requestSpecification = given().
                contentType(contentType);

        if (getAuthBearerHeader() != null)
            requestSpecification.header(getAuthBearerHeader());

        if (headers != null && headers.length > 0)
            Arrays.stream(headers).forEach(h -> requestSpecification.header(h));

        response = requestSpecification
                .when().get(url)
                .then()
                .extract().response();

        return response;
    }

    public Response delete(String url, ContentType contentType, Header... headers) {
        RequestSpecification requestSpecification = given().
                contentType(contentType);

        if (getAuthBearerHeader() != null)
            requestSpecification.header(getAuthBearerHeader());

        if (headers != null && headers.length > 0)
            Arrays.stream(headers).forEach(h -> requestSpecification.header(h));

        response = requestSpecification
                .when().delete(url)
                .then()
                .extract().response();

        return response;
    }

    public Response validateStatusCode(Integer status) {
        Assert.assertTrue("Action failed with code " + response.getStatusCode() + " but expected was " + status,
                response.getStatusCode() == status);
        return response;
    }
}
