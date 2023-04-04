package com.ecommerce.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
}
