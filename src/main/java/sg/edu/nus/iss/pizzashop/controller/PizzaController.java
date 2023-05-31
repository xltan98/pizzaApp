package sg.edu.nus.iss.pizzashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.pizzashop.model.Delivery;
import sg.edu.nus.iss.pizzashop.model.Order;
import sg.edu.nus.iss.pizzashop.model.Pizza;

@Controller
//@RequestMapping()

public class PizzaController {


    @GetMapping(path="/")
    public String showLandingPage(Model m, HttpSession session, Pizza p){
        m.addAttribute("pizza", new Pizza());
        //session.getAttribute("pizza");
        //session.getAttribute("pizza", p);
        
        return "index";

    }
    @PostMapping(path="/pizza")
    public String postInformation(@ModelAttribute @Valid Pizza p,BindingResult result, Model m, HttpSession sess){
        if(result.hasErrors()){
            return "index";
        }
        m.addAttribute("delivery", new Delivery());
        sess.setAttribute("pizza", p);
        return "information";
    }
    @PostMapping(path="/order")
    public String postOrder(@ModelAttribute @Valid Delivery d,BindingResult result, Model m, HttpSession sess){
        if(result.hasErrors()){
            return "information";
        }
        String id =Order.idGenerator();
        m.addAttribute("id", id);
        Pizza p = (Pizza)sess.getAttribute("pizza");
        double totalcost=Order.getOrderCost(p);
        

        

        return "order";
    }






    
}
