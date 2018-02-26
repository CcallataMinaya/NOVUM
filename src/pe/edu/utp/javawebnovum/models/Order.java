package pe.edu.utp.javawebnovum.models;

import java.util.Date;

public class Order {
    private int id;
    private int user_id;
    private int thematic_id;
    private int package_id;
    private Date date_order;
    private Date start_time;
    private String location;
    private float total_price;
    private User user;

    public Order() {
    }

    public Order(int id, int user_id, int thematic_id,int package_id,Date date_order,Date start_time,String location,float total_price, User user) {
        this.id = id;
        this.user_id = user_id;
        this.thematic_id = thematic_id;
        this.package_id = package_id;
        this.date_order = date_order;
        this.start_time = start_time;
        this.location = location;
        this.total_price = total_price;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public Order setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public int getThematic_id() {
        return thematic_id;
    }

    public Order setThematic_id(int thematic_id) {
        this.thematic_id = thematic_id;
        return this;
    }

    public int getPackage_id() {
        return package_id;
    }

    public Order setPackage_id(int package_id) {
        this.package_id = package_id;
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

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }
}
