<<<<<<< HEAD
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
=======
package com.ecommerce.client;

import com.ecommerce.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ClientDto extends UserDto implements Serializable {
    private String username;



}
>>>>>>> 4fd60159d56d751dc9c3219729c6aec6c20f7c09
