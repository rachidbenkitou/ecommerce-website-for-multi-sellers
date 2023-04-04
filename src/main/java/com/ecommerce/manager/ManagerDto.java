package com.ecommerce.manager;

import com.ecommerce.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class ManagerDto extends UserDto implements Serializable {
}
