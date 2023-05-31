package sg.edu.nus.iss.pizzashop.model;

import jakarta.json.JsonObject;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Pizza {
    @NotNull(message="Must select a pizza")
    private String pizza;

    @NotNull(message="Must select pizza size")
    private String size;

    @Min(value=1, message="You must order at least 1")
    @Max(value=10, message="You can order maximum 10")
    private Integer quantity;

    public String getPizza() {
        return pizza;
    }
    public void setPizza(String pizza) {
        this.pizza = pizza;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static Pizza create(JsonObject o){
        Pizza p = new Pizza();
        p.setPizza(o.getString("pizza"));
        p.setSize(o.getString("size"));
        p.setQuantity(o.getInt("quantity"));

        return p;   
    }







    
}
