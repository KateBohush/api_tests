package de.fidor.dal.datamodels.cardservice;

import de.fidor.dal.datamodels.cardservice.carddata.CardCollection;
import de.fidor.dal.datamodels.cardservice.carddata.CardData;
import lombok.Data;

@Data
public class GetCardResponse {

   private CardData[] data;
   private CardCollection collection;
}
