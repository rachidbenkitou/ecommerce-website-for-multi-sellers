package com.ecommerce.subCategory;

import com.ecommerce.category.CategoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {
    SubCategoryDto modelToDto(SubCatgeory subCatgeory);
    List<SubCategoryDto> modelToDtos(List<SubCatgeory> subCatgeories);
    SubCatgeory dtoToModel(CategoryDto categoryDto);
}
