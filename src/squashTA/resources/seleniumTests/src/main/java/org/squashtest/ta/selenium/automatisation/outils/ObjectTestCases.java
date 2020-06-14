package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

import java.util.List;

public class ObjectTestCases {

    private List<SingleTestCases> test_cases;

    public ObjectTestCases() {}

    public ObjectTestCases(List<SingleTestCases> test_cases) {
        this.test_cases = test_cases;
    }

    public List<SingleTestCases> getTest_cases() {
        return test_cases;
    }

    public void setTest_cases(List<SingleTestCases> test_cases) {
        this.test_cases = test_cases;
    }

    @Override
    public String toString() {
        return "ObjectTestCases{" +
                "test_cases=" + test_cases +
                '}';
    }
}
