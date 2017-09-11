package de.fidor.tests;

import de.fidor.core.CustomEasyTestRunner;
import de.fidor.testdata.converters.TestCaseConverter;
import org.easetech.easytest.annotation.Converters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;

@RunWith(CustomEasyTestRunner.class)
@Converters({TestCaseConverter.class})
public abstract class TestBase {

    private static boolean alreadyDone = false;
    private final org.slf4j.Logger LOG = LoggerFactory.getLogger(TestBase.class);


    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
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

    @Before
    public void generalTestInit() {
        if (!alreadyDone) {

        }

    }
}