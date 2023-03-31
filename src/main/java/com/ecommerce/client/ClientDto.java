package com.ecommerce.client;

import com.ecommerce.order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto implements Serializable {
    private String username;
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
    private List<Order> orders;
}
