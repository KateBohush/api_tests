package de.fidor.bl.services.endpoints;


import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import de.fidor.bl.services.ServiceFactory;
import de.fidor.dal.datamodels.cardservice.GetCardResponse;
import de.fidor.dal.datamodels.infrastructure.ResponseWithData;

public class CardService extends ServiceFactory {

   private final String CARD_END_POINT = env + "/fidor_api/cards";

   public ResponseWithData getCardUsingToken(String access_token) {
      Header[] headers = {
            new Header("Authorization", "Bearer " + access_token),
            new Header("Accept", "application/vnd.fidor.de; version=1,text/json")
      };

      ResponseWithData<GetCardResponse> response = new ResponseWithData<>();

      Response resp = getClient().get(CARD_END_POINT, ContentType.JSON, headers);
      response.setHttpFullResponse(resp);
      response.setResponseEntity(resp.getBody().as(GetCardResponse.class));

      return response;
   }

}
