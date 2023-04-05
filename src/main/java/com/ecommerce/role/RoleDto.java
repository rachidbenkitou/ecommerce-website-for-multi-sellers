package com.ecommerce.role;

import com.ecommerce.permission.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto implements Serializable {
    private String roleId;
    private String roleName;
    private List<Permission> permissions;

}
