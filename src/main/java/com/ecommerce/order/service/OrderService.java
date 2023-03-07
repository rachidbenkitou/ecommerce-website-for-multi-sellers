package com.ecommerce.order.service;

import com.ecommerce.order.OrderDto;

import java.util.List;

public interface OrderService {

    public List<OrderDto> listOrder();
    OrderDto SaveOrder(OrderDto orderDto);
    OrderDto updateOrder(OrderDto orderDto);
    List<OrderDto> findOrder(long id);
    void deleteOrdre(long id);
}
