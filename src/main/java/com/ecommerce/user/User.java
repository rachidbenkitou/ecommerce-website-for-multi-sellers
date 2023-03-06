package com.ecommerce.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.Serializable;


@Document
@Data
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User implements Serializable {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;

}
