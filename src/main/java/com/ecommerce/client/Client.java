package com.ecommerce.client;


import com.ecommerce.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document
@Data
@AllArgsConstructor
public class Client extends User implements Serializable {
   private String username;
}

