package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.Captures;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils.GetSquashTmDataSet;
import squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils.Main;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

public class TestClass extends Main {

    private StringBuffer verificationErrors = new StringBuffer();
    private String dataSet;

    public TestClass() {
        dataSet = "Captures.TestClass";
        if (testCaseName != null)
            testTest();
    }

    @Before
    public void setUp() {
        testCaseName = "Auth 01";
        super.setUp();
    }

    @Test
    public void testTest() {
        System.out.println("-------------> " + GetSquashTmDataSet.getValueByName(dataSet, "in_param_one"));
        driver.get(GetSquashTmDataSet.getValueByName(dataSet, "in_param_one"));
        assertTrue(true);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}