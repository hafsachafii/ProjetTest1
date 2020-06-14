package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

public class ObjectTestCase {

    private String _type;
    private int id;
    private String name;
    private ObjectSelf _links;


    public ObjectTestCase(String _type, int id, String name, ObjectSelf _links) {
        this._type = _type;
        this.id = id;
        this.name = name;
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

    public ObjectSelf get_links() {
        return _links;
    }

    public void set_links(ObjectSelf _links) {
        this._links = _links;
    }
}
