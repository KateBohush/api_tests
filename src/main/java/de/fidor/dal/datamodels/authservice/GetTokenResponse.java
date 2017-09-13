package de.fidor.dal.datamodels.authservice;

import lombok.Data;

@Data
public class GetTokenResponse {
    private String access_token;
    private Integer expires_in;
    private String token_type;
    private String refresh_token;
}
