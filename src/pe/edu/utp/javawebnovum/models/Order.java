package pe.edu.utp.javawebnovum.models;

import java.util.Date;

public class Order {
    private int id;
    private User owner_id;
    private User client_id;
    private Thematic thematic;
    private Package aPackage;
    private Date date_order;
    private Date start_time;
    private String location;
    private float total_price;

    public Order() {
    }

    public Order(int id, User owner_id, User client_id, Thematic thematic, Package aPackage, Date date_order, Date start_time, String location, float total_price) {
        this.id = id;
        this.owner_id = owner_id;
        this.client_id = client_id;
        this.thematic = thematic;
        this.aPackage = aPackage;
        this.date_order = date_order;
        this.start_time = start_time;
        this.location = location;
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public User getOwner_id() {
        return owner_id;
    }

    public Order setOwner_id(User owner_id) {
        this.owner_id = owner_id;
        return this;
    }

    public User getClient_id() {
        return client_id;
    }

    public Order setClient_id(User client_id) {
        this.client_id = client_id;
        return this;
    }

    public Thematic getThematic() {
        return thematic;
    }

    public Order setThematic(Thematic thematic) {
        this.thematic = thematic;
        return this;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public Order setaPackage(Package aPackage) {
        this.aPackage = aPackage;
        return this;
    }

    public Date getDate_order() {
        return date_order;
    }

    public Order setDate_order(Date date_order) {
        this.date_order = date_order;
        return this;
    }

    public Date getStart_time() {
        return start_time;
    }

    public Order setStart_time(Date start_time) {
        this.start_time = start_time;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Order setLocation(String location) {
        this.location = location;
        return this;
    }

    public float getTotal_price() {
        return total_price;
    }

    public Order setTotal_price(float total_price) {
        this.total_price = total_price;
        return this;
    }


}