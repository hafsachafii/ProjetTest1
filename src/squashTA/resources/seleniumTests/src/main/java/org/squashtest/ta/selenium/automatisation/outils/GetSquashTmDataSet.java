package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetSquashTmDataSet {

    private static String testCaseSolliciter;
    private static Gson gson;
    private static URL url;
    private static byte[] b64;
    private static URLConnection conn ;
    private static BufferedReader bufferedReader;
    private static Type type;
    private static Map<String,Dataset> dataset;
    private static Dataset singleDataset;
    private static TestCases testCases;
    private static String content, line;
    private static boolean statut;
    private static PrintWriter printWriter;
    private static ObjectDatasets objectDatasets;
    private static ObjectSteps objectSteps;
    private static String login, password;
    private static ObjectTestCaseMap map;

    public GetSquashTmDataSet() { }

    public static void getAllTestCases() {
        try{
            gson = new Gson();
            url = new URL("http://192.168.165.128:7770/squash/api/rest/latest/test-cases?page=0&size=1000");
            b64 = Base64.encodeBase64((login+":"+password).getBytes());
            conn = url.openConnection();
            conn.setRequestProperty("Authorization", "Basic " + new String(b64));
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            alterString(bufferedReader);

            type = new TypeToken<TestCases>(){}.getType();
            testCases = gson.fromJson(content, type);

        }catch (Exception e){e.printStackTrace();}
    }

    public static ObjectSteps getAllTestSteps(String testCasUrl){
        try{
            gson = new Gson();
            url = new URL(testCasUrl);
            b64 = Base64.encodeBase64((login+":"+password).getBytes());
            conn = url.openConnection();
            conn.setRequestProperty("Authorization", "Basic " + new String(b64));
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            type = new TypeToken<ObjectSteps>(){}.getType();
            objectSteps = gson.fromJson(bufferedReader, type);
            return objectSteps;
        }catch (Exception e){e.printStackTrace();}
        return null;
    }

    public static ObjectDatasets getDatasetByTestCase(String datasetUrl) {
        try{
            gson = new Gson();
            url = new URL(datasetUrl);
            b64 = Base64.encodeBase64((login+":"+password).getBytes());
            conn = url.openConnection();
            conn.setRequestProperty("Authorization", "Basic " + new String(b64));
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            type = new TypeToken<ObjectDatasets>(){}.getType();
            objectDatasets = gson.fromJson(bufferedReader, type);
            return objectDatasets;
        }catch (Exception e){e.printStackTrace();}
        return null;
    }

    public static void getTestCaseMap(){
        try{
            gson = new Gson();
            bufferedReader = new BufferedReader(new FileReader("src/squashTA/resources/files/TestCaseMap.json"));
            type = new TypeToken<ObjectTestCaseMap>(){}.getType();
            map = gson.fromJson(bufferedReader, type);

        }catch (Exception e){e.printStackTrace();}
    }


    public static Dataset getSingleDataset(String urlApi, String datasetName) {
        try{
            gson = new Gson();
            url = new URL(urlApi);
            b64 = Base64.encodeBase64((login+":"+password).getBytes());
            conn = url.openConnection();
            conn.setRequestProperty("Authorization", "Basic " + new String(b64));
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            type = new TypeToken<Dataset>(){}.getType();
            singleDataset = gson.fromJson(bufferedReader, type);

            dataset.put(datasetName, singleDataset);

            return singleDataset;
        }catch (Exception e){e.printStackTrace();}
        return null;
    }

    public static String getValueByName(String datasetName, String parameterName){
       for(ObjectValue item : dataset.get(datasetName).getParameter_values()){
           if(item.getParameter_name().equalsIgnoreCase(parameterName))
               return item.getParameter_value();
       }
       return "";
    }

    public static Object launchTestByName(String testCaseName, Dataset called_dataset) {
        try{
            for(ObjectTestCaseMapElements item : getMap().getTestCaseMap()){
                if(item.getCasDeTest().equals(testCaseName)){
                    getSingleDataset(called_dataset.get_links().getSelf().getHref(), item.getClassDeTest());

                    Class<?> c = Class.forName("squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium." + item.getClassDeTest());
                    Constructor<?> cons = c.getConstructor();
                    return cons.newInstance();
                }
            }
        }catch (Exception e){e.printStackTrace();}

        return null;
    }

    public static Object launchTestByNameWithOutDataSet(String testCaseName) {
        try{
            for(ObjectTestCaseMapElements item : getMap().getTestCaseMap()){
                if(item.getCasDeTest().equals(testCaseName)){
                    Class<?> c = Class.forName("squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium." + item.getClassDeTest());
                    Constructor<?> cons = c.getConstructor();
                    return cons.newInstance();
                }
            }
        }catch (Exception e){e.printStackTrace();}

        return null;
    }

    public static String getClassDeTestName(String testCaseName) {
        try{
            for(ObjectTestCaseMapElements item : getMap().getTestCaseMap()){
                if(item.getCasDeTest().equals(testCaseName))
                    return item.getClassDeTest();
            }
        }catch (Exception e){e.printStackTrace();}

        return null;
    }

    public static void alterString(BufferedReader reader){
        try {
            statut = true;
            content = "";
            while (reader.ready()){
                line = reader.readLine();
                if(line.contains("test-cases") && statut){
                    line = "\"test_cases\" : [ {";
                    statut = false;
                }
                content += line;
            }
        }catch (Exception e){ e.printStackTrace(); }
    }

    public static List<ObjectStepElement> getCalledSteps(ObjectSteps objectSteps){
        ArrayList<ObjectStepElement> list = new ArrayList<ObjectStepElement>();

        if(objectSteps.getElements() != null){
            for (ObjectStepElement item : objectSteps.getElements()){
                if(item.get_type().equals("call-step"))
                    list.add(item);
            }
        }
        return list;
    }

    public static void saveAsJsonFile(Object o){
        try {
            printWriter = new PrintWriter(new File("src/squashTA/resources/files/filePrinter.json"));
            printWriter.write(content);
            printWriter.flush();

        }catch (Exception e){ e.printStackTrace(); }
    }


    // Getter & Setter

    public static ObjectSteps getObjectSteps() {
        return objectSteps;
    }

    public static void setLoginAndPassword(String login, String password) {
        GetSquashTmDataSet.login = login;
        GetSquashTmDataSet.password = password;
    }

    public static ObjectDatasets getObjectDatasets() {
        return objectDatasets;
    }

    public static Map<String, Dataset> getDataset() {
        return dataset;
    }

    public static void setDataset(Map<String, Dataset> dataset) {
        GetSquashTmDataSet.dataset = dataset;
    }

    public static ObjectTestCaseMap getMap() {
        return map;
    }

    public static TestCases getTestCases() {
        return testCases;
    }

    public static String getTestCaseSolliciter() {
        return testCaseSolliciter;
    }

    public static void setTestCaseSolliciter(String testCaseSolliciter) {
        GetSquashTmDataSet.testCaseSolliciter = testCaseSolliciter;
    }
}