package com.ecommerce.role.service;

import com.ecommerce.role.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAllRoles();
    List<RoleDto> getRolesByName(String roleName);
    RoleDto saveRole(RoleDto roleDto);
    RoleDto updateRole(RoleDto roleDto);
    void deleteRoleByName(String roleName);
}
