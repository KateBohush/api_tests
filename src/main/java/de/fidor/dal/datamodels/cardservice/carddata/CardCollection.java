package de.fidor.dal.datamodels.cardservice.carddata;

import lombok.Data;

@Data
public class CardCollection {

   private Integer current_page;
   private Integer per_page;
   private Integer total_entries;
   private Integer total_pages;
}
