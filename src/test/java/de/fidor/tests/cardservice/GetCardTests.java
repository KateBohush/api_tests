package de.fidor.tests.cardservice;


import de.fidor.bl.services.ServiceFactory;
import de.fidor.bl.validators.CardServiceValidator;
import de.fidor.bl.validators.ValidatorFactory;
import de.fidor.dal.datamodels.authservice.GetTokenRequest;
import de.fidor.dal.datamodels.cardservice.GetCardResponse;

import de.fidor.dal.datamodels.infrastructure.ResponseWithData;
import de.fidor.tests.TestBase;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.annotation.Parallel;
import org.easetech.easytest.loader.LoaderType;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Features;

@DataLoader(filePaths = {"src/test/java/de/fidor/testdata/GetCardData.xls"}, loaderType = LoaderType.EXCEL, writeData = false)
@Parallel(threads = 10)
@Features({"some feature"})
public class GetCardTests extends TestBase {

   @Test
   public void getCardValid(GetTokenRequest requestData, GetCardResponse expectedData) {
      String access_token = getAccessToken(requestData);
      ResponseWithData actualData = ServiceFactory.getCardService().getCardUsingToken(access_token);
      CardServiceValidator cardServiceValidator = ValidatorFactory.getCardServiceValidator(actualData);
      cardServiceValidator.verifyCardWasReturned(expectedData);
   }
}

