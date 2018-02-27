package pe.edu.utp.javawebnovum.beans;

import pe.edu.utp.javawebnovum.models.HrService;
import pe.edu.utp.javawebnovum.models.Thematic;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ThematicsBean implements Serializable{
    private HrService service;
    private Thematic thematic;

    public ThematicsBean(){
        service = new HrService();
    }

    public List<Thematic> getRegions(){
        return service.findAllThematics();
    }

    public Thematic getThematic() {
        return thematic;
    }

    public void setThematic(Thematic thematic) {
        this.thematic = thematic;
    }

    public String getName() {
        return this.getThematic().getName();
    }

    public void setName(String name){
        this.getThematic().setName(name);
    }

    public String getPhoto() {
        return this.getThematic().getPhoto();
    }

    public void setPhoto(String photo){
        this.getThematic().setPhoto(photo);
    }

    public String getDescription() {
        return this.getThematic().getDescription();
    }

    public void setDescription(String description){
        this.getThematic().setDescription(description);
    }

    public String newThematic(){
        this.setThematic(new Thematic());
        return "success";
    }

    public String createRegion(){
        service.createThematic(this.getName(),this.getPhoto(),this.getDescription());
        return "success";
    }

    public String editThematic(Thematic thematic){
        this.setThematic(thematic);
        return "success";
    }

    public String updateThematic(){
        service.updateThematic(this.getThematic());
        return "success";
    }
    public String deleteThematic(Thematic thematic){
        service.deleteThematic(thematic.getId());
        return "success";
    }
}
