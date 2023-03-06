package com.ecommerce.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.Serializable;
@Data
@Document
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
}
