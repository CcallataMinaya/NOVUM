package pe.edu.utp.javawebnovum.models;

public class PackageDetail {
    private Package aPackage;
    private Thematic thematic;
    private User owner;
    private User client;
    private float total_price;
    private String description;

    public PackageDetail(Package aPackage, Thematic thematic, User owner, User client, float total_price, String description) {
        this.aPackage = aPackage;
        this.thematic = thematic;
        this.setOwner(owner);
        this.setClient(client);
        this.total_price = total_price;
        this.description = description;
    }

    public PackageDetail() {

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
    public User getOwner() {
        return owner;
    }

    public PackageDetail setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public User getClient() {
        return client;
    }

    public PackageDetail setClient(User client) {
        this.client = client;
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