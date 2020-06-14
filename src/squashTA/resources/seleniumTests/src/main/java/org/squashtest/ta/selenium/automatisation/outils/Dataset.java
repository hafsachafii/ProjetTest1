package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

import java.util.List;

public class Dataset {

    private String _type;
    private int id;
    private String name;
    private List<ObjectParameter> parameters;
    private List<ObjectValue> parameter_values;
    private ObjectTestCase test_case;
    private ObjectLinks _links;


    public Dataset(String _type, int id, String name, List<ObjectParameter> parameters, List<ObjectValue> parameter_values, ObjectTestCase test_case, ObjectLinks _links) {
        this._type = _type;
        this.id = id;
        this.name = name;
        this.parameters = parameters;
        this.parameter_values = parameter_values;
        this.test_case = test_case;
        this._links = _links;
    }


    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ObjectParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<ObjectParameter> parameters) {
        this.parameters = parameters;
    }

    public List<ObjectValue> getParameter_values() {
        return parameter_values;
    }

    public void setParameter_values(List<ObjectValue> parameter_values) {
        this.parameter_values = parameter_values;
    }

    public ObjectTestCase getTest_case() {
        return test_case;
    }

    public void setTest_case(ObjectTestCase test_case) {
        this.test_case = test_case;
    }

    public ObjectLinks get_links() {
        return _links;
    }

    public void set_links(ObjectLinks _links) {
        this._links = _links;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "_type='" + _type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", parameters=" + parameters +
                ", parameter_values=" + parameter_values +
                ", test_case=" + test_case +
                ", _links=" + _links +
                '}';
    }
}
