package pe.edu.utp.javawebnovum.models;

public class PackageDetail {
    private Package aPackage;
    private Thematic thematic;
    private User user;
    private float total_price;
    private String description;

    public PackageDetail(Package aPackage, Thematic thematic, User user, float total_price, String description) {
        this.aPackage = aPackage;
        this.thematic = thematic;
        this.user = user;
        this.total_price = total_price;
        this.description = description;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public PackageDetail setaPackage(Package aPackage) {
        this.aPackage = aPackage;
        return this;
    }

    public Thematic getThematic() {
        return thematic;
    }

    public PackageDetail setThematic(Thematic thematic) {
        this.thematic = thematic;
        return this;
    }

    public User getUser() {
        return user;
    }

    public PackageDetail setUser(User user) {
        this.user = user;
        return this;
    }

    public float getTotal_price() {
        return total_price;
    }

    public PackageDetail setTotal_price(float total_price) {
        this.total_price = total_price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PackageDetail setDescription(String description) {
        this.description = description;
        return this;
    }
}