package com.ecommerce.order.service;

import com.ecommerce.order.Excetion.OrderNotFoundException;
import com.ecommerce.order.Order;
import com.ecommerce.order.OrderDto;
import com.ecommerce.order.OrderMapper;
import com.ecommerce.order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class OrderServiceImplement implements OrderService{
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    @Override
    public List<OrderDto> listOrder() {
        List<Order> orderList = orderRepository.findAll();
        if(orderList.isEmpty()){
             throw new OrderNotFoundException("No order is found");
        }

        return orderMapper.modelToDtos(orderList);
    }
    /**
     * @param
     * @return
     */
    @Override
    public OrderDto SaveOrder(OrderDto orderDto) {

        Order order = orderMapper.dtoToModel(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.modelToDto(savedOrder);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        Order order = orderMapper.dtoToModel(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.modelToDto(savedOrder);
    }

    @Override
    public List<OrderDto> findOrder(long id) {
        List<Order> order=orderRepository.findOrdersByOrderId(id);
        return orderMapper.modelToDtos(order);
    }

    @Override
    public void deleteOrdre(long id) {
          orderRepository.deleteById(id);
    }
}
