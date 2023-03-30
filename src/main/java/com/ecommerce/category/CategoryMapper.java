package com.ecommerce.category;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CategoryMapper {
    CategoryDto modelToDto(Category category);
    List<CategoryDto> modelToDtos(List<Category> categories);
    Category dtoToModel(CategoryDto categoryDto);
}
