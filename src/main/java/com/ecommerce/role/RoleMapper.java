package com.ecommerce.role;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface RoleMapper {
    RoleDto modelToDto(Role role);
    List<RoleDto> modelToDtos(List<Role> roles);
    Role dtoToModel(RoleDto roleDto);
}
