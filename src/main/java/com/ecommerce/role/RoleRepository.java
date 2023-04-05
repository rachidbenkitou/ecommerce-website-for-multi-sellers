package com.ecommerce.role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    List<Role> findAllByRoleNameLikeIgnoreCase(String roleName);
    boolean existsRoleByRoleName(String roleName);
    void  deleteByRoleName(String roleName);
}
