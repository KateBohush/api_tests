package de.fidor.testdata.converters.cardservice;

import com.google.gson.Gson;

import de.fidor.dal.datamodels.cardservice.GetCardResponse;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;


public class GetCardExpectedResponseConverter extends AbstractConverter<GetCardResponse> {
   @Override
   public GetCardResponse convert(Map<String, Object> convertFrom) {
      GetCardResponse getCardExpectedResponse = null;

      if (convertFrom != null) {
         Gson gson = new Gson();
         getCardExpectedResponse = gson.fromJson((String) convertFrom.get("expected_response"), GetCardResponse.class);
      }

      return getCardExpectedResponse;
   }
}