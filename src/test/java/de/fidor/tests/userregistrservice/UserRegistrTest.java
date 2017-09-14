package de.fidor.tests.userregistrservice;

import de.fidor.bl.services.ServiceFactory;
import de.fidor.bl.validators.ValidatorFactory;
import de.fidor.dal.datamodels.authservice.GetTokenRequest;
import de.fidor.dal.datamodels.authservice.GetTokenResponse;
import de.fidor.dal.datamodels.infrastructure.GherkinTestCase;
import de.fidor.dal.datamodels.infrastructure.ResponseWithData;
import de.fidor.dal.datamodels.userregistrservice.RegistrationRequest;
import de.fidor.dal.datamodels.userregistrservice.RegistrationResponse;
import de.fidor.tests.TestBase;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Parallel;
import org.easetech.easytest.loader.LoaderType;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Features;

@DataLoader(filePaths = {"src/test/java/de/fidor/testdata/UserRegistrTest.xls"}, loaderType = LoaderType.EXCEL, writeData = false)
@Parallel(threads = 2)
@Features({"some feature"})
public class UserRegistrTest extends TestBase {

    @Test
    public void registerUserValid(RegistrationRequest requestData, RegistrationResponse expectedData, GherkinTestCase testCase) {
        System.out.println(requestData);
        System.out.println(expectedData);
        ResponseWithData actualData = ServiceFactory.getUserRegistrService().register(converter.toJson(requestData));
        System.out.println("++++++++++++++++" + actualData.getResponseEntity());

        //ValidatorFactory.getUserRegistrSeviceValidator(actualData).verifyUserWasRegistered(expectedData);
    }
}
