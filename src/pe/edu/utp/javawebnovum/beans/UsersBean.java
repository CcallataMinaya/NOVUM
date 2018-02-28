package pe.edu.utp.javawebnovum.beans;

import pe.edu.utp.javawebnovum.models.HrService;
import pe.edu.utp.javawebnovum.models.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UsersBean implements Serializable {
    private HrService service;
    private User user;

    public UsersBean(){
        service = new HrService();
    }

    public List<User> getUsers(){ return service.findAllUsers();    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return this.getUser().getPassword();
    }

    public void setPassword(String password){
        this.getUser().setPassword(password);
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
        service.updateUser(this.getUser());
        return "success";
    }
    public String deleteUser(User user){
        //service.deleteUser(user.getId());
        return "success";
    }
}
