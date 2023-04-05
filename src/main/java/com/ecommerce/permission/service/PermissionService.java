package com.ecommerce.permission.service;

import com.ecommerce.permission.PermissionDto;

import java.util.List;

public interface PermissionService {
    List<PermissionDto> getAllPermissions();
    List<PermissionDto> getPermissionsByName(String permissionName);
    PermissionDto savePermission(PermissionDto permissionDto);
    PermissionDto updatePermission(PermissionDto permissionDto);
    void deletePermissionByName(String permissionName);
}
