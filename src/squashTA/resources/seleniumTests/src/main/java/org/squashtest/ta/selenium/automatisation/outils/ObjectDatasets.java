package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

import java.util.List;

public class ObjectDatasets {

    private List<Dataset> datasets;

    public ObjectDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public ObjectDatasets() {}

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    @Override
    public String toString() {
        return "ObjectDatasets{" +
                "datasets=" + datasets +
                '}';
    }
}
