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
