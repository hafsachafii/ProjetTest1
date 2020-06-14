package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

public class ObjectValue {
    private String parameter_test_case_id;
    private String parameter_value;
    private String parameter_name;
    private int parameter_id;


    public ObjectValue(String parameter_test_case_id, String parameter_value, String parameter_name, int parameter_id) {
        this.parameter_test_case_id = parameter_test_case_id;
        this.parameter_value = parameter_value;
        this.parameter_name = parameter_name;
        this.parameter_id = parameter_id;
    }

    public String getParameter_test_case_id() {
        return parameter_test_case_id;
    }

    public void setParameter_test_case_id(String parameter_test_case_id) {
        this.parameter_test_case_id = parameter_test_case_id;
    }

    public String getParameter_value() {
        return parameter_value;
    }

    public void setParameter_value(String parameter_value) {
        this.parameter_value = parameter_value;
    }

    public String getParameter_name() {
        return parameter_name;
    }

    public void setParameter_name(String parameter_name) {
        this.parameter_name = parameter_name;
    }

    public int getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(int parameter_id) {
        this.parameter_id = parameter_id;
    }

    @Override
    public String toString() {
        return "ObjectValue{" +
                "parameter_test_case_id='" + parameter_test_case_id + '\'' +
                ", parameter_value='" + parameter_value + '\'' +
                ", parameter_name='" + parameter_name + '\'' +
                ", parameter_id=" + parameter_id +
                '}';
    }
}
