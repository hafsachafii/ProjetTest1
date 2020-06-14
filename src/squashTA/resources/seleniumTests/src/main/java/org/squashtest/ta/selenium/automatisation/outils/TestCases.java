package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

public class TestCases {

    private ObjectTestCases _embedded;
    private ObjectLinks _links;
    private ObjectPage page;


    public TestCases(){}

    public TestCases(ObjectTestCases _embedded, ObjectLinks _links, ObjectPage page) {
        this._embedded = _embedded;
        this._links = _links;
        this.page = page;
    }

    public ObjectTestCases get_embedded() {
        return _embedded;
    }

    public void set_embedded(ObjectTestCases _embedded) {
        this._embedded = _embedded;
    }

    public ObjectLinks get_links() {
        return _links;
    }

    public void set_links(ObjectLinks _links) {
        this._links = _links;
    }

    public ObjectPage getPage() {
        return page;
    }

    public void setPage(ObjectPage page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "TestCases{" +
                "_embedded=" + _embedded +
                ", _links=" + _links +
                ", page=" + page +
                '}';
    }
}
