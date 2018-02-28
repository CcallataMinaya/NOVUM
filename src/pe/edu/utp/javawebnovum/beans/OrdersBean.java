package pe.edu.utp.javawebnovum.beans;

import pe.edu.utp.javawebnovum.models.*;
import pe.edu.utp.javawebnovum.models.Package;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class OrdersBean implements Serializable {
    private HrService service;
    private Order order;

    public OrdersBean(){
        service = new HrService();
    }

    public List<Order> getOrders(){ return service.findAllOrders();    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getUser() {
        return this.getOrder().getUser().getId();
    }

    public void setUser(User user){
        this.getOrder().setUser(user);
    }

    public int getThematics() { return this.getOrder().getThematic().getId(); }

    public void setThematics(Thematic thematic){
        this.getOrder().setThematic(thematic);
    }

    public int getPackage() {
        return this.getOrder().getaPackage().getId();
    }

    public void setPackage(Package apackage){
        this.getOrder().setaPackage(apackage);
    }

    public Date getDate_order () {
        return this.getOrder().getDate_order();
    }

    public void setDate_order(Date date_order){
        this.getOrder().setDate_order(date_order);
    }

    public Date getStart_time () {
        return this.getOrder().getStart_time();
    }

    public void setStart_time(Date start_time){
        this.getOrder().setStart_time(start_time);
    }

    public String getLocation () {
        return this.getOrder().getLocation();
    }

    public void setLocation(String location){
        this.getOrder().setLocation(location);
    }

    public float getTotal_price () {
        return this.getOrder().getTotal_price();
    }

    public void setTotal_price(float total_price){
        this.getOrder().setTotal_price(total_price);
    }


    public String newPOrder(){
        this.setOrder(new Order());
        return "success";
    }

    /* public String createPackageDetail(){
         service.createPackageDetail(this.getaPackage(), this.getThematic(),this.getUser(),this.getTotal_price(), this.getDescription());
         return "success";
     }
 */
    public String editOrder(Order order){
        this.setOrder(order);
        return "success";
    }

    /*public String updatePackageDetail(){
        service.updatePackageDetail(this.getPackagDetail());
        return "success";
    }*/
    public String deleteOrder(Order order){
        service.deleteUser(order.getId());
        return "success";
    }
}
