package de.fidor.tests;

import com.google.gson.Gson;
import de.fidor.bl.services.ServiceFactory;
import de.fidor.core.CustomEasyTestRunner;
import de.fidor.dal.datamodels.authservice.GetTokenRequest;
import de.fidor.dal.datamodels.authservice.GetTokenResponse;
import de.fidor.dal.datamodels.infrastructure.ResponseWithData;
import de.fidor.testdata.converters.TestCaseConverter;
import de.fidor.testdata.converters.authservice.GetTokenExpectedResponseConverter;
import de.fidor.testdata.converters.authservice.GetTokenRequestConverter;
import de.fidor.testdata.converters.cardservice.GetCardExpectedResponseConverter;
import org.easetech.easytest.annotation.Converters;
import org.easetech.easytest.annotation.Display;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;

@RunWith(CustomEasyTestRunner.class)
@Converters({TestCaseConverter.class, GetTokenRequestConverter.class, GetTokenExpectedResponseConverter.class, GetCardExpectedResponseConverter.class})
@Display(fields = "description")
public abstract class TestBase {

   private static boolean alreadyDone = false;
   private final org.slf4j.Logger LOG = LoggerFactory.getLogger(TestBase.class);
   protected Gson converter = new Gson();


    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
      }

      @Override
      protected void starting(Description description) {
         LOG.debug("Starting test : " + description.getMethodName());
         LOG.debug("======================================");
      }

      @Override
      protected void finished(Description description) {
         LOG.debug("Finished test : " + description.getMethodName());
         LOG.debug("======================================");
      }

   };

   public String getAccessToken(GetTokenRequest requestData) {
      ResponseWithData responseWithData = ServiceFactory.getAuthService().getTokenUsingPassword(converter.toJson(requestData));
      GetTokenResponse response = (GetTokenResponse) responseWithData.getResponseEntity();
      return response.getAccess_token();
   }

   @Before
   public void generalTestInit() {
      if (!alreadyDone) {

      }

   }
}