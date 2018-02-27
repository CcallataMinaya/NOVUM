package pe.edu.utp.javawebnovum.models;

public class PackageDetail {
    private int id;
    private int package_id;
    private int thematic_id;
    private int user_id;
    private float total_price;
    private String description;

    public PackageDetail() {
    }

    public PackageDetail(int id, int package_id, int thematic_id, int user_id, float total_price, String description) {
        this.id = id;
        this.thematic_id = thematic_id;
        this.user_id = user_id;
        this.total_price = total_price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPackage_id() {
        return package_id;
    }

    public PackageDetail setPackage_id(int package_id) {
        this.package_id = package_id;
        return  this;
    }

    public int getThematic_id() {
        return thematic_id;
    }

    public PackageDetail setThematic_id(int thematic_id) {
        this.thematic_id = thematic_id;
        return  this;
    }

    public int getUser_id() {
        return user_id;
    }

    public PackageDetail setUser_id(int user_id) {
        this.user_id = user_id;
        return  this;
    }

    public float getTotal_price() {
        return total_price;
    }

    public PackageDetail setTotal_price(float total_price) {
        this.total_price = total_price;
        return  this;
    }

    public String getDescription() {
        return description;
    }

    public PackageDetail setDescription(String description) {
        this.description = description;
        return  this;
    }
}
