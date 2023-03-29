package com.ecommerce.order;


import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto modelToDto(Order order);
    List<OrderDto> modelToDtos(List<Order> orderList);
    Order dtoToModel(OrderDto orderDto);
}
