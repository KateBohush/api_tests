package de.fidor.dal.datamodels.userregistrservice;

import lombok.Data;

@Data
public class GetTokenCredentialsResponse {
    private String access_token;
    private Integer expires_in;
    private String token_type;
    private String refresh_token;
}
