package com.ecommerce.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Role implements Serializable {
    @Id
    private String roleId;
    private String roleName;
}
