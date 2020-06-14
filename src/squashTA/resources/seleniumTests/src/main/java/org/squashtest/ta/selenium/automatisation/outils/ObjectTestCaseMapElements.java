package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

public class ObjectTestCaseMapElements {

    private String casDeTest;
    private String classDeTest;

    public ObjectTestCaseMapElements(String casDeTest, String classDeTest) {
        this.casDeTest = casDeTest;
        this.classDeTest = classDeTest;
    }

    public ObjectTestCaseMapElements() { }

    public String getCasDeTest() {
        return casDeTest;
    }

    public void setCasDeTest(String casDeTest) {
        this.casDeTest = casDeTest;
    }

    public String getClassDeTest() {
        return classDeTest;
    }

    public void setClassDeTest(String classDeTest) {
        this.classDeTest = classDeTest;
    }

    @Override
    public String toString() {
        return "ObjectTestCaseMap{" +
                "casDeTest='" + casDeTest + '\'' +
                ", classDeTest='" + classDeTest + '\'' +
                '}';
    }
}
