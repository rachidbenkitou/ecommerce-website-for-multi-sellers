package com.ecommerce.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Order {
    @Id
    private long orderId;
    private Date date;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
