package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

import java.util.List;

public class ObjectSteps {
    private List<ObjectStepElement> steps;

    public ObjectSteps(){}

    public ObjectSteps(List<ObjectStepElement> elements) {
        this.steps = elements;
    }

    public List<ObjectStepElement> getElements() {
        return steps;
    }

    public void setElements(List<ObjectStepElement> elements) {
        this.steps = elements;
    }

    @Override
    public String toString() {
        return "ObjectSteps{" +
                "elements=" + steps +
                '}';
    }
}
