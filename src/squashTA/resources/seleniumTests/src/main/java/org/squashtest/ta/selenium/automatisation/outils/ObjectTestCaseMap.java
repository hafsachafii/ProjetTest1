package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

import java.util.ArrayList;

public class ObjectTestCaseMap {

    private ArrayList<ObjectTestCaseMapElements> testCaseMap;

    public ObjectTestCaseMap(ArrayList<ObjectTestCaseMapElements> testCaseMap) {
        this.testCaseMap = testCaseMap;
    }

    public ObjectTestCaseMap() { }

    public ArrayList<ObjectTestCaseMapElements> getTestCaseMap() {
        return testCaseMap;
    }

    public void setTestCaseMap(ArrayList<ObjectTestCaseMapElements> testCaseMap) {
        this.testCaseMap = testCaseMap;
    }

    @Override
    public String toString() {
        return "ObjectTestCaseMap{" +
                "testCaseMap=" + testCaseMap +
                '}';
    }
}
