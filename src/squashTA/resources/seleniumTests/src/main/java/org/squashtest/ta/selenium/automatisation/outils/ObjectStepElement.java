package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

public class ObjectStepElement {

    private String _type;
    private int id;
    private boolean delegate_parameter_values;
    private SingleTestCases called_test_case;
    private Dataset called_dataset;
    private int index;
    private ObjectLinks _links;


    public ObjectStepElement(String _type, int id, boolean delegate_parameter_values, SingleTestCases called_test_case, Dataset called_dataset, int index, ObjectLinks _links) {
        this._type = _type;
        this.id = id;
        this.delegate_parameter_values = delegate_parameter_values;
        this.called_test_case = called_test_case;
        this.called_dataset = called_dataset;
        this.index = index;
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

    public boolean isDelegate_parameter_values() {
        return delegate_parameter_values;
    }

    public void setDelegate_parameter_values(boolean delegate_parameter_values) {
        this.delegate_parameter_values = delegate_parameter_values;
    }

    public SingleTestCases getCalled_test_case() {
        return called_test_case;
    }

    public void setCalled_test_case(SingleTestCases called_test_case) {
        this.called_test_case = called_test_case;
    }

    public Dataset getCalled_dataset() {
        return called_dataset;
    }

    public void setCalled_dataset(Dataset called_dataset) {
        this.called_dataset = called_dataset;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ObjectLinks get_links() {
        return _links;
    }

    public void set_links(ObjectLinks _links) {
        this._links = _links;
    }

    @Override
    public String toString() {
        return "ObjectStepElement{" +
                "_type='" + _type + '\'' +
                ", id=" + id +
                ", delegate_parameter_values=" + delegate_parameter_values +
                ", called_test_case=" + called_test_case +
                ", called_dataset=" + called_dataset +
                ", index=" + index +
                ", _links=" + _links +
                '}';
    }
}
