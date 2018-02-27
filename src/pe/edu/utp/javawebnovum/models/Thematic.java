package pe.edu.utp.javawebnovum.models;

public class Thematic {

    private int id;
    private String name;
    private String photo;
    private String description;

    public Thematic() {
    }

    public Thematic(int id, String name, String photo, String description) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public Thematic setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Thematic setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Thematic setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Thematic setDescription(String description) {
        this.description = description;
        return this;
    }
}
