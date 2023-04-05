package com.ecommerce.permission;

import com.ecommerce.role.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends MongoRepository<Permission, String> {
    List<Permission> findPermissionByPermissionNameLikeIgnoreCase(String permissionName);
    boolean existsPermissionByPermissionName(String permissionName);
    void  deleteByPermissionName(String permissionName);
}
