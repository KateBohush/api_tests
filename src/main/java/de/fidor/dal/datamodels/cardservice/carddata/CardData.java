package de.fidor.dal.datamodels.cardservice.carddata;

import lombok.Data;

@Data
public class CardData {

   private Integer id;
   private String account_id;
   private String inscription;
   private String type;
   private String design;
   private String currency;
   private Boolean physical;
   private String valid_until;
   private Integer balance;
   private Integer atm_limit;
   private Integer transaction_single_limit;
   private Integer transaction_volume_limit;

   private Limits limits;

   private Boolean email_notification;
   private Boolean sms_notification;
   private Boolean payed;
   private String state;
   private String lock_reason;
   private Boolean disabled;

   private AtmDetails atm_details;

   private String pan;
   private String updated_at;
   private String created_at;
}
