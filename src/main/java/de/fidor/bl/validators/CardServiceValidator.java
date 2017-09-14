package de.fidor.bl.validators;


import de.danielbechler.diff.node.DiffNode;
import de.fidor.dal.datamodels.cardservice.GetCardResponse;
import de.fidor.dal.datamodels.infrastructure.ResponseWithData;
import org.junit.Assert;

public class CardServiceValidator extends DataValidator {

   public CardServiceValidator(ResponseWithData response) {
      super(response);
   }

   public void verifyCardWasReturned(GetCardResponse expectedResult) {
      validateStatusCode(200);
      setIgnoreProps(GetCardResponse.class, "data");
      GetCardResponse actualEntity = (GetCardResponse) response.getResponseEntity();
      Assert.assertEquals("Actual result differs from expected",
            DiffNode.State.UNTOUCHED, compare(expectedResult, actualEntity).getDiffState());
      Assert.assertTrue(actualEntity.getData() != null);
      Assert.assertTrue(actualEntity.getCollection() != null);
   }
}