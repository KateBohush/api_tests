package de.fidor.dal.datamodels.userregistrservice;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String email;
    private String first_name;
    private String last_name;
    private String password;
    private String birthday;
    private String nick;
    private String maiden_name;
    private String adrStreet;
    private String adr_street_number;
    private String adr_postCode;
    private String adrCity;
    private String birthplace;
    private String adr_country;
    private String adr_phone;
    private Integer title;
    private boolean us_citizen;
    private boolean us_tax_payer;
    private String verification_token;
    private String gender;
    private boolean own_interest;
    private boolean tos;
    private boolean privacy_policy;
    private String adr_mobile;
    private String affiliate_uid;
}
