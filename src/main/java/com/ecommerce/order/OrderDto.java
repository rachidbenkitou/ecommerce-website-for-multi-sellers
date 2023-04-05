package com.ecommerce.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private long orderId;
    private Date date;
    private OrderStatus orderStatus;

}
