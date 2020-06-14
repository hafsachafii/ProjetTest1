package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

import java.io.Serializable;

public class ObjectParameter implements Serializable {

    private String _type;
    private String name;
    private int id;
    private static final long serialVersionUID = 1L;

    public ObjectParameter(){}

    public ObjectParameter(String _type, String name, int id) {
        this._type = _type;
        this.name = name;
        this.id = id;
    }

    public String get_type() {
        return _type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ObjetParameter{" +
                "_type='" + _type + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
