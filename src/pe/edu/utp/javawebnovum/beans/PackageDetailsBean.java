package pe.edu.utp.javawebnovum.beans;

import pe.edu.utp.javawebnovum.models.HrService;
import pe.edu.utp.javawebnovum.models.PackageDetail;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PackageDetailsBean implements Serializable {
    private HrService service;
    private PackageDetail packagedetail;


    public PackageDetailsBean(){
        service = new HrService();
    }

    public List<PackageDetail> getPackageDetail(){ return service.findAllUsers();    }

    public PackageDetail getPackagDetail() {
        return packagedetail;
    }

    public void getPackagDetail(PackageDetail packagedetail) {
        this.packagedetail = packagedetail;
    }

    public int getPackage_id() {
        return this.getPackagDetail().getPackage_id();
    }

    public void setPackage_id(int package_id){
        this.getPackagDetail().setPackage_id(package_id);
    }

    public int getThematic_id() {
        return this.getPackagDetail().getThematic_id();
    }

    public void setThematic_id(int thematic_id){
        this.getPackagDetail().setThematic_id(thematic_id);
    }

    public int getUser_id() {
        return this.getPackagDetail().getUser_id();
    }

    public void setUser_id(int user_id){
        this.getPackagDetail().setUser_id(user_id);
    }

    public float getTotal_price () {
        return this.getPackagDetail().getTotal_price();
    }

    public void setTotal_price(float total_price){
        this.getPackagDetail().setTotal_price(total_price);
    }

    public String getDescription () {
        return this.getPackagDetail().getDescription();
    }

    public void setDescription(String description){
        this.getPackagDetail().setDescription(description);
    }
    
    public String getName() { return this.getUser().getName(); }

    public void setName(String name){
        this.getUser().setName(name);
    }

    public String getLast_Name() { return this.getUser().getLast_name(); }

    public void setLast_Name(String last_name){
        this.getUser().setLast_name(last_name);
    }

    public String getAddress() { return this.getUser().getAddress(); }

    public void setAddress(String address){
        this.getUser().setAddress(address);
    }

    public String getDni() { return this.getUser().getDni(); }

    public void setDni(String dni){
        this.getUser().setDni(dni);
    }

    public String getRol() { return this.getUser().getRol(); }

    public void setRol(String rol){
        this.getUser().setRol(rol);
    }

    public String getEmail() { return this.getUser().getEmail(); }

    public void setEmail(String email){
        this.getUser().setEmail(email);
    }

    public String newUser(){
        this.setUser(new User());
        return "success";
    }

    public String createUser(){
        service.createUser(this.getPassword(),this.getName(),this.getLast_Name(),getAddress(), getDni(), getRol(),getEmail());
        return "success";
    }

    public String editUser(User region){
        this.setUser(user);
        return "success";
    }

    public String updateUser(){
        //service.updateUser(this.getUser());
        return "success";
    }
    public String deleteUser(User user){
        //service.deleteUser(user.getId());
        return "success";
    }
}