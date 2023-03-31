package com.ecommerce.productOrder;

import com.ecommerce.Product.Product;
import com.ecommerce.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class ProductOrder {
    @Id
    private String id;
    @DBRef()
    private Product product;
    @DBRef()
    private Order order;
    private int quatity;
}
