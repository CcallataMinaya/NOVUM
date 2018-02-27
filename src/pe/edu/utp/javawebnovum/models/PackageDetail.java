package pe.edu.utp.javawebnovum.models;

public class PackageDetail {
    private int id;
    private int package_id;
    private int thematic_id;
    private int user_id;
    private float total_price;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPackage_id() {
        return package_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public int getThematic_id() {
        return thematic_id;
    }

    public void setThematic_id(int thematic_id) {
        this.thematic_id = thematic_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
