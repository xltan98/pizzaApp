package sg.edu.nus.iss.pizzashop.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Delivery {

    @Size(min=3, message ="minimum three letters")
    @NotNull(message="Please type in your name")
    private String name;

    @NotNull(message="Please type in your address")
    private String address;

    @Size(min=8,max=8, message="phone number must be 8 digits")
    @NotNull(message="Please type in your phone number")
    private String phone;

    private boolean rush;
    private String comments;

    
    public Delivery() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean isRush() {
        return rush;
    }
    public void setRush(boolean rush) {
        this.rush = rush;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }


    
    
}
