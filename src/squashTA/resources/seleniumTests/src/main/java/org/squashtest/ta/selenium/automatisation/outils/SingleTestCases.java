package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

public class SingleTestCases {

    private String _type;
    private int id;
    private String name;
    private String reference;
    private ObjectLinks _links;


    public SingleTestCases(){}

    public SingleTestCases(String _type, int id, String name, String reference, ObjectLinks _links) {
        this._type = _type;
        this.id = id;
        this.name = name;
        this.reference = reference;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public ObjectLinks get_links() {
        return _links;
    }

    public void set_links(ObjectLinks _links) {
        this._links = _links;
    }

    @Override
    public String toString() {
        return "TestCases{" +
                "_type='" + _type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", reference='" + reference + '\'' +
                ", _links=" + _links +
                '}';
    }
}
