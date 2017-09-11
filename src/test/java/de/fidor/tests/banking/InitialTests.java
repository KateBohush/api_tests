package de.fidor.tests.banking;

import de.fidor.testdata.converters.GherkinTestCase;
import de.fidor.tests.TestBase;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.annotation.Parallel;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Features;

@DataLoader(filePaths = {"src/test/java/de/fidor/testdata/test.xls"}, loaderType = LoaderType.EXCEL, writeData = false)
@Parallel(threads = 10)
@Features({"some feature"})
@Display(fields = {"description"})
public class InitialTests extends TestBase {


    @Test
    public void testTry(@Param(name = "new") String someParam,
                        GherkinTestCase testCase){
        System.out.println(someParam);
    }
}
