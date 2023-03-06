package com.ecommerce.supplier;

import com.ecommerce.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@ToString
public class Supplier extends User {

    @Autowired
    public Supplier(String id, String firstName, String lastName, String email, String password, String city) {
        super(id, firstName, lastName, email, password, city);
    }
}
