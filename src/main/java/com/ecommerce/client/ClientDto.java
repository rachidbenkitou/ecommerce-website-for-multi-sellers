package com.ecommerce.client;

import com.ecommerce.order.Order;
import com.ecommerce.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDto extends UserDto implements Serializable{
    private List<Order> orders;
}
