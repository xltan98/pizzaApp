package sg.edu.nus.iss.pizzashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.pizzashop.model.Pizza;

@Controller
//@RequestMapping()
public class PizzaController {

    @GetMapping(path="/")
    public String showLandingPage(Model m){
        m.addAttribute("pizza", new Pizza());
        return "index";

    }





    
}
