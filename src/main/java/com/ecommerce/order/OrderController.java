package com.ecommerce.order;

import com.ecommerce.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("order")
@CrossOrigin("*")
public class OrderController {
    private OrderService orderService;

    @GetMapping("/all")
    public List<OrderDto> getAllOrders(){
        return orderService.listOrder();
    }
    @GetMapping("/find/{id}")
    public List<OrderDto> findOrder(@PathVariable long id ){
        return orderService.findOrder(id);
    }

    @PostMapping("/save")
    public OrderDto saveOrder(@RequestBody OrderDto orderDto){
        return orderService.SaveOrder(orderDto);
    }
    @PutMapping ("/update/{id}")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto){
        return orderService.updateOrder(orderDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable long id){
        orderService.deleteOrdre(id);

    }


}
