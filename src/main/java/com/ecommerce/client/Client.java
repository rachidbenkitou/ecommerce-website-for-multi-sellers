package com.ecommerce.client;


import com.ecommerce.user.User;

import lombok.AllArgsConstructor;
import lombok.ToString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;




@Document
@ToString
@AllArgsConstructor
public class Client extends User {

}
