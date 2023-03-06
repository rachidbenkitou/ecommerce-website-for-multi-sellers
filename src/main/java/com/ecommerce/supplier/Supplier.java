package com.ecommerce.supplier;

import com.ecommerce.user.User;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@AllArgsConstructor
@ToString
public class Supplier extends User {


}
