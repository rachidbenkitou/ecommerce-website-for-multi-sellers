package com.ecommerce.permission.service;

import com.ecommerce.manager.ManagerDto;
import com.ecommerce.permission.Permission;
import com.ecommerce.permission.PermissionDto;
import com.ecommerce.permission.PermissionMapper;
import com.ecommerce.permission.PermissionRepository;
import com.ecommerce.permission.exception.NoPermissionFoundException;
import com.ecommerce.permission.exception.PermissionAlreadyExistException;
import com.ecommerce.role.Role;
import com.ecommerce.role.RoleDto;
import com.ecommerce.role.RoleMapper;
import com.ecommerce.role.RoleRepository;
import com.ecommerce.role.exception.NoRoleFoundException;
import com.ecommerce.role.exception.RoleAlreadyExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService{
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public List<PermissionDto> getAllPermissions() {
        // Retrieve all permissions from the database as a list.
        List<Permission> permissions=permissionRepository.findAll();
        if (permissions.isEmpty()) throw  new NoPermissionFoundException("Permission list is empty");
        // Convert the list of Permission objects to a list of PermissionDto objects and return it.
        return permissionMapper.modelToDtos(permissions);
    }

    @Override
    public List<PermissionDto> getPermissionsByName(String permissionName) {
        // Retrieve all permissions by name from the database as a list.
        List<Permission> permissions=permissionRepository.findPermissionByPermissionNameLikeIgnoreCase(permissionName);
        if (permissions.isEmpty()) throw  new NoPermissionFoundException("No permission found with this name");
        // Convert the list of Permission objects to a list of PermissionDto objects and return it.
        return permissionMapper.modelToDtos(permissions);
    }

    @Override
    public PermissionDto savePermission(PermissionDto permissionDto) {
        // We first check whether the permission already exists in the database. If it exists, a PermissionAlreadyExistException will be thrown.
        if(isPermissionExist(permissionDto.getPermissionName()))
            throw new PermissionAlreadyExistException(String.format("The permission %s is already  exists.", permissionDto.getPermissionName()));
        return savedPermission(permissionDto);
    }
    @Override
    public PermissionDto updatePermission(PermissionDto permissionDto) {
        return savedPermission(permissionDto);
    }
    @Override
    public void deletePermissionByName(String permissionName) {
        permissionRepository.deleteByPermissionName(permissionName);
    }
    /**
     * Check if a permission exists in the database.
     *
     * @param permissionName The name of permission that we will check if exists in the database.
     * @return If the permission exists, the function returns true, if not, it returns false.
     */
    private boolean isPermissionExist(String permissionName){
        boolean isExistPermission=permissionRepository.existsPermissionByPermissionName(permissionName);
        if(isExistPermission) return true;
        else return false;
    }
    /**
     * save a permission in the database.
     *
     * @param permissionDto The  role that we will save in the database.
     * @return the permission that we just saved in the database.
     */
    public PermissionDto savedPermission(PermissionDto permissionDto){
        return permissionMapper.modelToDto(permissionRepository.save(permissionMapper.dtoToModel(permissionDto)));
    }
}
