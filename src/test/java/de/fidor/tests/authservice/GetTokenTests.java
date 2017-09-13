package de.fidor.tests.authservice;

import de.fidor.bl.services.ServiceFactory;
import de.fidor.bl.validators.ValidatorFactory;
import de.fidor.dal.datamodels.authservice.GetTokenRequest;
import de.fidor.dal.datamodels.authservice.GetTokenResponse;
import de.fidor.dal.datamodels.infrastructure.GherkinTestCase;
import de.fidor.dal.datamodels.infrastructure.ResponseWithData;
import de.fidor.tests.TestBase;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.annotation.Parallel;
import org.easetech.easytest.loader.LoaderType;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Features;

@DataLoader(filePaths = {"src/test/java/de/fidor/testdata/GetTokenData.xls"}, loaderType = LoaderType.EXCEL, writeData = false)
@Parallel(threads = 10)
@Features({"some feature"})
@Display(fields = {"description"})
public class GetTokenTests extends TestBase {

    @Test
    public void getTokenValid(GetTokenRequest requestData, GetTokenResponse expectedData, GherkinTestCase testCase) {
        ResponseWithData actualData = ServiceFactory.getAuthService().getTokenUsingPassword(converter.toJson(requestData));
        ValidatorFactory.getAuthServiceValidator(actualData).verifyTokenWasReturned(expectedData);
    }

}