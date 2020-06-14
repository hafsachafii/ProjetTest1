package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main{
    protected static WebDriver driver;
    private ChromeOptions options;
    protected static String testCaseName = null;
    protected ObjectDatasets objectDatasets = new ObjectDatasets();
    protected static ObjectSteps objectSteps = new ObjectSteps();
    protected Dataset dataset;
    protected List<ObjectStepElement> listOfCalledSteps;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor javascriptExecutor;


    @Before
    public void setUp() {
        try{
            /**
             * instantiating objects
             * prepare the webDriver
             */
            System.setProperty("webdriver.chrome.driver", "src/squashTA/resources/webDriver/chromedriver.exe");
            initDriver();

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            // driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 30);
            javascriptExecutor = (JavascriptExecutor) driver;

            GetSquashTmDataSet.setDataset(new HashMap<String, Dataset>());

            /**
             * reading of JSON file to map the tests cases with tests scripts JAVA/Selenium
             */
            getMapFromJsonFile();

            /**
             * API Squash-TM Authentication
             */
            GetSquashTmDataSet.setLoginAndPassword("admin", "admin");

            /**
             * return all test cases defined under Squash-TM
             */
            GetSquashTmDataSet.getAllTestCases();
            /**
             * return the test case
             */
            getTestCase(testCaseName);
            /**
             * return the dataset that corresponds to the test case
             */
            dataset = getDataset(objectDatasets);
            /**
             * return all test steps with CALL type
             */
            listOfCalledSteps = GetSquashTmDataSet.getCalledSteps(objectSteps);
            /**
             * lunch the test steps with CALL type
             */
            if(objectSteps.getElements() != null){
                for(ObjectStepElement item : objectSteps.getElements()) {
                    if(item.get_type().equals("call-step"))
                        GetSquashTmDataSet.launchTestByName(item.getCalled_test_case().getName(), item.getCalled_dataset());
                    else
                        break;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void getMapFromJsonFile(){
        /**
         * lire le fichier qui permet de savoir la correspondance entre les cas de tests défini dans Squash-TM avec leurs class-Java de test !
         */
        GetSquashTmDataSet.getTestCaseMap();
    }

    public void getTestCase(String testCaseName){
        for (SingleTestCases item : GetSquashTmDataSet.getTestCases().get_embedded().getTest_cases()) {
            if (item.getName().equalsIgnoreCase(testCaseName)){
                objectDatasets = GetSquashTmDataSet.getDatasetByTestCase(item.get_links().getSelf().getHref());
                objectSteps = GetSquashTmDataSet.getAllTestSteps(item.get_links().getSelf().getHref());
                break;
            }
        }
    }

    public Dataset getDataset(ObjectDatasets objectDatasets){
        if(objectDatasets.getDatasets() != null) {
            for (Dataset item : objectDatasets.getDatasets())
                return GetSquashTmDataSet.getSingleDataset(item.get_links().getSelf().getHref(), GetSquashTmDataSet.getClassDeTestName(testCaseName));
        }
        return null;
    }

    private void initDriver() {
        options = new ChromeOptions();
     //   options.addArguments("--headless"); // disabling extensions
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox");
    }
}
