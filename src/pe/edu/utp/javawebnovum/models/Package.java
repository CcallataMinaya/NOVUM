package pe.edu.utp.javawebnovum.models;

public class Package {

    private int id;
    private String name;
    private String description;

    public Package() {
    }

    public Package( String name, String description) {

        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Package setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Package setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Package setDescription(String description) {
        this.description = description;
        return this;
    }

}
