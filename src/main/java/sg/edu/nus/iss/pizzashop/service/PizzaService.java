package sg.edu.nus.iss.pizzashop.service;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.pizzashop.model.Delivery;
import sg.edu.nus.iss.pizzashop.model.Order;
import sg.edu.nus.iss.pizzashop.model.Pizza;
@Service
public class PizzaService {

    public double totalPrice(Pizza p,Delivery d){
        if (d.isRush()){
            double rushCost = 2.00;
       return Order.getOrderCost(p)+rushCost;
        }
        return Order.getOrderCost(p);
    }
    
}
