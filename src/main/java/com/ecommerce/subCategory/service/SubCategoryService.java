package com.ecommerce.subCategory.service;

import com.ecommerce.subCategory.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {
    List<SubCategoryDto> getAllSubCategories();
    List<SubCategoryDto> getSubCategoriesByName(String subCategoryName);
    SubCategoryDto saveSubCategory(SubCategoryDto subCategoryDto);
    SubCategoryDto updateSubCategory(SubCategoryDto subCategoryDto);
    void deleteSubCategoryByName(String subCategoryName);
}