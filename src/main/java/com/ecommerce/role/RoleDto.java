package com.ecommerce.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto implements Serializable {
    private String roleId;
    private String roleName;
}
