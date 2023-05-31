package sg.edu.nus.iss.pizzashop.model;

import java.util.HashMap;
import java.util.UUID;

public class Order {

    //HashMap <String,Double> costOfPizza= new HashMap<>();
    private String orderNumber;
    private String address;
    private double pizzaCost;
    private Boolean rush;
    private double totalCost;



    public static String idGenerator(){
        UUID uuid= UUID.randomUUID();
        String id = uuid.toString().replace("-","").substring(0, 8);
        return id;
    }

    public static double getOrderCost(Pizza p){
        if(p.getPizza().equals("Bella")||p.getPizza().equals("Marinara")||p.getPizza().equals("Spianata Calabrese")){
                double cost=30.00;
            if(p.getSize().equals("sm")){
                
                return (cost*1*p.getQuantity());
            }
            if(p.getSize().equals("md")){
                
                return (cost*1.2*p.getQuantity());
            }
            if(p.getSize().equals("lg")){
                
                return (cost*1.5*p.getQuantity());
            }
        }
            if(p.getPizza().equals("Margherita")){
                double cost=22.00;
            if(p.getSize().equals("sm")){
                
                return (cost*1*p.getQuantity());
            }
            if(p.getSize().equals("md")){
                
                return (cost*1.2*p.getQuantity());
            }
            if(p.getSize().equals("lg")){
                
                return (cost*1.5*p.getQuantity());
            }
        }
       
        if(p.getPizza().equals("Trio Formaggio")){
            double cost=25.00;
        if(p.getSize().equals("sm")){
            
            return (cost*1*p.getQuantity());
        }
        if(p.getSize().equals("md")){
            
            return (cost*1.2*p.getQuantity());
        }
        if(p.getSize().equals("lg")){
            
            return (cost*1.5*p.getQuantity());
        }
    }
    return 0;
    }



    


    
}
