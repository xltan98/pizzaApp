package sg.edu.nus.iss.pizzashop.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import sg.edu.nus.iss.pizzashop.model.Delivery;
import sg.edu.nus.iss.pizzashop.model.Order;
import sg.edu.nus.iss.pizzashop.model.Pizza;
import sg.edu.nus.iss.pizzashop.repository.PizzaRespository;
@Service
public class PizzaService {
    @Autowired
    private PizzaRespository respository;
    
    public static final String[] PIZZA_NAMES = {
        "bella", "margherita", "marinara", "spianatacalabrese", "trioformaggio"
    };

    public static final String[] PIZZA_SIZES={
        "sm",
        "md",
        "lg"
    };
    //FIXED VALUE SO ITS HARDCODE --> BASICALLY CONSTANT

    private final Set<String> pizzaNames;
    private final Set<String> pizzaSizes;

    public PizzaService(){
        pizzaNames = new HashSet<String>(Arrays.asList(PIZZA_NAMES));
        pizzaSizes = new HashSet<String>(Arrays.asList(PIZZA_SIZES));
    }

    public List<ObjectError> validatePizzaOrder(Pizza p){
        List<ObjectError> errors = new LinkedList<>();
        FieldError error;
        if(!pizzaNames.contains(p.getPizza().toLowerCase())){
            error= new FieldError("pizza","pizza","we do  not have the %s pizza".formatted(p.getPizza()));
            errors.add(error);
            
        }

    
            if(!pizzaSizes.contains(p.getSize().toLowerCase())){
                error= new FieldError("pizza","pizza","we do  not have the %s pizza size".formatted(p.getSize()));
                errors.add(error);
                
            }
        // new field("person","firstName")
        return errors;
    }
    // final static dont allow u to change anything

    // public double totalPrice(Pizza p,Delivery d){
    //     if (d.isRush()){
    //         double rushCost = 2.00;
    //    return Order.getOrderCost(p)+rushCost;
    //     }
    //     return Order.getOrderCost(p);
    // }
    
}
