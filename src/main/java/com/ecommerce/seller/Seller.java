package com.ecommerce.seller;

import com.ecommerce.Product.Product;
import com.ecommerce.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@AllArgsConstructor
@Document
public class Seller extends User {
    private String username;
    private String  description;
    @ReadOnlyProperty
    private List<Product> products;

}
