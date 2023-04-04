package com.ecommerce.manager;

import com.ecommerce.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@AllArgsConstructor
@Data
@Document
public class Manager extends User {

}
