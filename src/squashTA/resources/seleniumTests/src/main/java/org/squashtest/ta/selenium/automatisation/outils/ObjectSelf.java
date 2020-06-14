package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

public class ObjectSelf {

    private String href;

    public ObjectSelf(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "ObjectSelf{" +
                "href='" + href + '\'' +
                '}';
    }
}
