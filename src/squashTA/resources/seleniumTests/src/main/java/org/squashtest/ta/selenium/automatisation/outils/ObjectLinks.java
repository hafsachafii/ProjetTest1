package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

public class ObjectLinks {

    private ObjectSelf self;

    public ObjectLinks() {
    }

    public ObjectLinks(ObjectSelf self) {
        this.self = self;
    }

    public ObjectSelf getSelf() {
        return self;
    }

    public void setSelf(ObjectSelf self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return "ObjectLinks{" +
                "self=" + self +
                '}';
    }
}
