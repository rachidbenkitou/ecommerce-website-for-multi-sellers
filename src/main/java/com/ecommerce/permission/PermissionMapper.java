package com.ecommerce.permission;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface PermissionMapper {
    PermissionDto modelToDto(Permission permission);
    List<PermissionDto> modelToDtos(List<Permission> permissions);
    Permission dtoToModel(PermissionDto permissionDto);
}
