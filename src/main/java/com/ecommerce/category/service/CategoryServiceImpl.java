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

    /**
     * Retrieves categories by name from the database and returns them as a list of CategoryDto objects.
     *
     * @param categoryName The name of the category that we will search for in the database
     * @return a list of CategoryDto objects representing  categories by name in the database
     */
    @Override
    public List<CategoryDto> getCategoriesByName(String categoryName) {
        // Retrieve all categories by name from the database as a list.
        List<Category> categories=categoryRepository.findCategoriesByCategoryName(categoryName);
        // Convert the list of Category objects to a list of CategoryDto objects and return it.
        return categoryMapper.modelToDtos(categories);
    }

    /**
     * Save a category in the database.
     *
     * @param categoryDto The category that we will save in the database.
     * @throws CategoryAlreadyExistException If the category already exists in the database, a CategoryAlreadyExistException will be thrown.
     * @return an object of category that we justalready saved.
     */
    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        // We first check whether the category already exists in the database. If it exists, a CategoryAlreadyExistException will be thrown.
        if(isCategoryExist(categoryDto.getCategoryName()))
            throw new CategoryAlreadyExistException(String.format("The category %s is already  exists.", categoryDto.getCategoryName()));
        return savedCategory(categoryDto);
    }
    /**
     * Update a category in the database.
     *
     * @param categoryDto The category that we will save in the database.
     * @throws CategoryAlreadyExistException If the category already exists in the database, a CategoryAlreadyExistException will be thrown.
     * @return an object of category that we just saved.
     */
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        return savedCategory(categoryDto);
    }
    @Override
    public void deleteCategoryByName(String categoryName) {
        categoryRepository.deleteCategoryByCategoryName(categoryName);
    }
    /**
     * Check if a category exists in the database.
     *
     * @param categoryName The name of category that we will check if exists in the database.
     * @return If the category exists, the function returns true, if not, it returns false.
     */
    private boolean isCategoryExist(String categoryName){
        boolean isExistategory=categoryRepository.existsByCategoryName(categoryName);
        if(isExistategory) return true;
        else return false;
    }
    /**
     * save a category in the database.
     *
     * @param categoryDto The  category that we will save in the database.
     * @return the category that we just saved in the database.
     */
    public CategoryDto savedCategory(CategoryDto categoryDto){
        return categoryMapper.modelToDto(categoryRepository.save(categoryMapper.dtoToModel(categoryDto)));
    }

}
