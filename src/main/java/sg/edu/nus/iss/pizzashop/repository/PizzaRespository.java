package sg.edu.nus.iss.pizzashop.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import sg.edu.nus.iss.pizzashop.model.Order;

public class PizzaRespository {
    @Autowired @Qualifier("pizza")
    // we added qualifier in redis to ensure the redistemplate is use the one u configured
    private RedisTemplate<String,String> template;
    // serailizer is string string

    public void save(Order o){
        template.opsForValue()
        .set(o.getOrderId(), o.toJSON().toString());
    }

    public Optional<Order> get(String orderId){
        String json = template.opsForValue().get(orderId);
        if((null == json || json.trim().length() <= 0)){
            return Optional.empty();
        }

        return Optional.of(Order.create(json));
    }
    
}
