package com.ecommerce.seller;

import com.ecommerce.Product.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.management.relation.Role;
import java.util.List;

@Data
@AllArgsConstructor
public class SellerDto {
    private String  username;
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
    private String  description;
    private List<Product> products;

}
