package com.ecommerce.manager;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ManagerMapper {
    ManagerDto modelToDto(Manager manager);
    List<ManagerDto> modelToDtos(List<Manager> managers);
    Manager dtoToModel(ManagerDto managerDto);
}


