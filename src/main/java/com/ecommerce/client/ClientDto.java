package com.ecommerce.client;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ClientDto implements Serializable {
    private String username;
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
}
