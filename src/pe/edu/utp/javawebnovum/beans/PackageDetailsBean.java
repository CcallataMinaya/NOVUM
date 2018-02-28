package pe.edu.utp.javawebnovum.beans;

import pe.edu.utp.javawebnovum.models.*;
import pe.edu.utp.javawebnovum.models.Package;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PackageDetailsBean implements Serializable {
    private HrService service;
    private PackageDetail packageDetail;


    public PackageDetailsBean(){
        service = new HrService();
    }

    public List<PackageDetail> getPackageDetails(){ return service.findAllPackageDetails();    }

    public PackageDetail getPackagDetail() {
        return packageDetail;
    }

    public void setPackagDetail(PackageDetail packagDetail) {
        this.packageDetail = packagDetail;
    }

    public int getaPackage() { return this.getPackagDetail().getaPackage().getId(); }

    public void setaPackage(Package packageDetail){
        this.getPackagDetail().setaPackage(packageDetail);
    }

    public int getThematic() {
        return this.getPackagDetail().getThematic().getId()
    }

    public void setThematic(Thematic thematic){
        this.getPackagDetail().setThematic(thematic);
    }

    public int getUser() {
        return this.getPackagDetail().getUser().getId();
    }

    public void setUser(User user){
        this.getPackagDetail().setUser(user);
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

    public String newPackageDetail(){
        this.setPackagDetail(new PackageDetail());
        return "success";
    }

    /*public String createPackageDetail(){
        service.createPackageDetail(this.getaPackage(), this.getThematic(),this.getUser(),this.getTotal_price(), this.getDescription());
        return "success";
    }*/

    public String editPackageDetail(PackageDetail packageDetail){
        this.setPackagDetail(packageDetail);
        return "success";
    }

    /*public String updatePackageDetail(){
        service.updatePackageDetail(this.getPackagDetail());
        return "success";
    }*/
    public String deletePackageDetail(PackageDetail packageDetail){
        service.deleteUser(packageDetail.getaPackage().getId());
        return "success";
    }
}