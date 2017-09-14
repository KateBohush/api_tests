package de.fidor.dal.datamodels.cardservice;

import de.fidor.dal.datamodels.cardservice.carddata.CardCollection;
import de.fidor.dal.datamodels.cardservice.carddata.CardData;
import lombok.Data;

import java.util.List;

@Data
public class GetCardResponse {

   private List<CardData> data;
   private CardCollection collection;

}
