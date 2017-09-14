package de.fidor.dal.datamodels.userregistrservice;

import lombok.Data;

@Data
public class RegistrationResponse {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String additional_first_name;
    private String gender;
    private String title;
    private String nick;
    private String maiden_name;
    private String adr_street;
    private Integer adr_street_number;
    private String adr_post_code;
    private String adr_city;
    private String birthplace;
    private String adr_country;
    private String adr_phone;
    private String adr_mobile;
    private String adr_fax;
    private String adr_businessphone;
    private String birthday;
    private Boolean is_verified;
    private String nationality;
    private String marital_status;
    private String occupation;
    private String religion;
    private String country_of_birth;
    private String preferred_language;
    private String id_card_registration_city;
    private String id_card_number;
    private String id_card_valid_until;
    private Legal legal;
    private String newsletter;
    private String affiliate_uid;
    private String community_user_picture;
    private String created_at;
    private String account_type;
    private String customer_number;
    private String updated_at;
}
