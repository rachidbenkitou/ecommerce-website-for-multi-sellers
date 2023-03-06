package com.ecommerce.category.service;

import com.ecommerce.category.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    List<CategoryDto> getCategoriesByName(String categoryName);
    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto);

    void deleteCategoryByName(String categoryName);
}
