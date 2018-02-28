package pe.edu.utp.javawebnovum.beans;

import pe.edu.utp.javawebnovum.models.HrService;
import pe.edu.utp.javawebnovum.models.Package;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PackagesBeans implements Serializable{
    private HrService service;
    private Package apackage;

    public PackagesBeans(){
        service = new HrService();
    }

    public List<Package> getUsers(){ return service.findAllPackages();    }

    public Package getPackage() {
        return apackage;
    }

    public void setPackage(Package apackage) {
        this.apackage = apackage;
    }

    public String getName() {
        return this.getPackage().getName();
    }

    public void setName(String name){
        this.getPackage().setName(name);
    }

    public String getDescription() { return this.getPackage().getDescription(); }

    public void setDescription(String description){
        this.getPackage().setDescription(description);
    }


    public String newPackage(){
        this.setPackage(new Package());
        return "success";
    }

    public String createPackage(){
        //service.createUser(this.getName(),this.getDescription());
        return "success";
    }

    public String editPackage(Package apackage){
        this.setPackage(apackage);
        return "success";
    }

    public String updatePackage(){
        service.updateUser(this.getPackage());
        return "success";
    }
    public String deletePackage(Package apackage){
        service.deleteUser(apackage.getId());
        return "success";
    }
}
