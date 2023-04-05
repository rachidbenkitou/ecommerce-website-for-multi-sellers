package com.ecommerce.role.service;

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
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDto> getAllRoles() {
        // Retrieve all roles from the database as a list.
        List<Role> roles=roleRepository.findAll();
        if (roles.isEmpty()) throw  new NoRoleFoundException("Role list is empty");
        // Convert the list of Role objects to a list of RoleDto objects and return it.
        return roleMapper.modelToDtos(roles);
    }

    @Override
    public List<RoleDto> getRolesByName(String roleName) {
        // Retrieve all roles by name from the database as a list.
        List<Role> roles=roleRepository.findAllByRoleNameLikeIgnoreCase(roleName);
        if (roles.isEmpty()) throw  new NoRoleFoundException("No role found with this name");
        // Convert the list of Role objects to a list of RoleDto objects and return it.
        return roleMapper.modelToDtos(roles);
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        // We first check whether the role already exists in the database. If it exists, a RoleAlreadyExistException will be thrown.
        if(isRoleExist(roleDto.getRoleName()))
            throw new RoleAlreadyExistException(String.format("The manager %s is already  exists.", roleDto.getRoleName()));
        return savedRole(roleDto);
    }
    @Override
    public RoleDto updateRole(RoleDto roleDto) {
        return savedRole(roleDto);
    }
    @Override
    public void deleteRoleByName(String roleName) {
        roleRepository.deleteByRoleName(roleName);
    }
    /**
     * Check if a role exists in the database.
     *
     * @param roleName The name of role that we will check if exists in the database.
     * @return If the role exists, the function returns true, if not, it returns false.
     */
    private boolean isRoleExist(String roleName){
        boolean isExistRole=roleRepository.existsRoleByRoleName(roleName);
        if(isExistRole) return true;
        else return false;
    }
    /**
     * save a role in the database.
     *
     * @param roleDto The  role that we will save in the database.
     * @return the role that we just saved in the database.
     */
    public RoleDto savedRole(RoleDto roleDto){
        return roleMapper.modelToDto(roleRepository.save(roleMapper.dtoToModel(roleDto)));
    }
}
