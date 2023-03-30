package com.ecommerce.subCategory;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {
    SubCategoryDto modelToDto(SubCategory subCatgeory);
    List<SubCategoryDto> modelToDtos(List<SubCategory> subCatgeories);
    SubCategory dtoToModel(SubCategoryDto SubCategoryDto);
}
