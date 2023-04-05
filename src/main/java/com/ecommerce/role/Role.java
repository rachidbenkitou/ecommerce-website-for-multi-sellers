package com.ecommerce.role;

import com.ecommerce.permission.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Role implements Serializable {
    @Id
    private String roleId;
    private String roleName;
    @DBRef
    private List<Permission> permissions;
}
