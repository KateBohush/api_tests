package de.fidor.dal.datamodels.authservice;

import lombok.Data;

@Data
public class GetTokenRequest {
    private String username;
    private String password;
    private String grant_type;
}
