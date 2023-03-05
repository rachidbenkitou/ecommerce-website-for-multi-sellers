package com.ecommerce.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@ToString
public class User implements Serializable {
    @Id
    private String id;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private String email;
    @Field
    private String password;
    @Field
    private String city;

}
