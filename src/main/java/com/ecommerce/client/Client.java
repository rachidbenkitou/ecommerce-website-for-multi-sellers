package com.ecommerce.client;


import com.ecommerce.order.Order;
import com.ecommerce.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User implements Serializable {
   @DBRef
   @ReadOnlyProperty
   private List<Order> orders = new ArrayList<>();
}

