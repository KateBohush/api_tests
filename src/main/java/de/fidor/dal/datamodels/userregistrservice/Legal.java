package de.fidor.dal.datamodels.userregistrservice;

import lombok.Data;

@Data
public class Legal {
    private boolean tos;

    private boolean us_tax_payer;

    private boolean own_interest;

    private String privacy_policy;

    private boolean us_citizen;

    private boolean community_terms_and_conditions;

}
