package com.ecommerce.category;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto modelToDto(Category category);
    List<CategoryDto> modelToDtos(List<Category> categories);
    Category dtoToModel(CategoryDto categoryDto);
}
