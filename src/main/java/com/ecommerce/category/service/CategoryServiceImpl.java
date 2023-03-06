package com.ecommerce.category.service;

import com.ecommerce.category.Category;
import com.ecommerce.category.CategoryDto;
import com.ecommerce.category.CategoryMapper;
import com.ecommerce.category.CategoryRepository;
import com.ecommerce.category.exception.CategoryAlreadyExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    /**
     * Retrieves all categories from the database and returns them as a list of CategoryDto objects.
     *
     * @return a list of CategoryDto objects representing all categories in the database
     */
    @Override
    public List<CategoryDto> getAllCategories() {
        // Retrieve all categories from the database as a list.
        List<Category> categories=categoryRepository.findAll();
        // Convert the list of Category objects to a list of CategoryDto objects and return it.
        return categoryMapper.modelToDtos(categories);
    }
    @Override
    public List<CategoryDto> getCategoriesByName(String categoryName) {
        // Retrieve all categories by name from the database as a list.
        List<Category> categories=categoryRepository.findCategoriesByCategoryName(categoryName);
        // Convert the list of Category objects to a list of CategoryDto objects and return it.
        return categoryMapper.modelToDtos(categories);
    }
    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        if(isCategoryExist(categoryDto.getCategoryName()))
            throw new CategoryAlreadyExistException(String.format("The category %s is already  exists.", categoryDto.getCategoryName()));
        return savedCategory(categoryDto);
    }
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        return savedCategory(categoryDto);
    }
    @Override
    public void deleteCategoryByName(String categoryName) {
        categoryRepository.deleteCategoryByCategoryName(categoryName);
    }
    boolean isCategoryExist(String categoryName){
        boolean isExistategory=categoryRepository.existsByCategoryName(categoryName);
        if(isExistategory) return true;
        else return false;
    }
    public CategoryDto savedCategory(CategoryDto categoryDto){
        return categoryMapper.modelToDto(categoryRepository.save(categoryMapper.dtoToModel(categoryDto)));
    }

}
