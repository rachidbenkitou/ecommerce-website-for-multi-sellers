package com.ecommerce.category.service;

import com.ecommerce.category.Category;
import com.ecommerce.category.CategoryDto;
import com.ecommerce.category.CategoryMapper;
import com.ecommerce.category.CategoryRepository;
import com.ecommerce.category.exception.CategoryAlreadyExistException;
import com.ecommerce.category.exception.NoCategoryFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {
    @Mock private CategoryRepository categoryRepository;
    @Mock private CategoryMapper categoryMapper;
    @InjectMocks private CategoryServiceImpl categoryService;


    private List<Category> categories;
    private List<CategoryDto> categoriesDtos;
    private Category category2;
    private Category category1;
    private CategoryDto categoryDto1;
    private  CategoryDto categoryDto2;
    String categoryName;
    @BeforeEach
    public void init() {
        categoryName="Book";
        category1= Category.builder().categoryId("id1").categoryName("Book1").build();
        category2= Category.builder().categoryId("id2").categoryName("Book2").build();
        categories= new ArrayList<>();
        categories.add(category1);
        categories.add(category2);

        categoryDto1= CategoryDto.builder().categoryId("id1").categoryName("Book1").build();
        categoryDto2= CategoryDto.builder().categoryId("id2").categoryName("Book2").build();
        categoriesDtos= new ArrayList<>();
        categoriesDtos.add(categoryDto1);
        categoriesDtos.add(categoryDto2);
    }

    @Test
    void shouldReturnListOfCategories() {
        // Mock category repository to return a list of categories
        when(categoryRepository.findAll()).thenReturn(categories);
        // Mock category mapper to return a list of categories dtos
        when(categoryMapper.modelToDtos(categories)).thenReturn(categoriesDtos);
        assertCategoryDtoList(categoryService.getAllCategories());
    }

    @Test
    void shouldReturnListOfCategoriesByName() {
        when(categoryRepository.findCategoriesByCategoryNameLikeIgnoreCase(categoryName)).thenReturn(categories);
        // Mock category mapper to return a list of category dtos
        when(categoryMapper.modelToDtos(categories)).thenReturn(categoriesDtos);
        assertCategoryDtoList(categoryService.getCategoriesByName(categoryName));
    }
    @Test
    void shouldThrowsNoCategoryNotFoundExceptionIfListOfCategoriesIsEmpty() {
        // Mock the category repository to return an empty list of categories
        when(categoryRepository.findAll()).thenReturn(Collections.emptyList());

        // Mock the category repository to return an empty list of categories
        when(categoryRepository.findCategoriesByCategoryNameLikeIgnoreCase(categoryName)).thenReturn(Collections.emptyList());

        // Test if NoCategoryFoundException is thrown
        Assertions.assertThatThrownBy(() -> categoryService.getAllCategories())
                .isInstanceOf(NoCategoryFoundException.class)
                .hasMessageContaining("Category list is empty");

        // Test if NoCategoryFoundException is thrown
        Assertions.assertThatThrownBy(() -> categoryService.getCategoriesByName(categoryName))
                .isInstanceOf(NoCategoryFoundException.class)
                .hasMessageContaining("No category found with this name");

        // Verify that the category repository method was called
        verify(categoryRepository, times(1)).findAll();

        // Verify that the category repository method was called
        verify(categoryRepository, times(1)).findCategoriesByCategoryNameLikeIgnoreCase(categoryName);
    }

    @Test
    void shouldSaveCategory() {
        when(categoryRepository.save(Mockito.any(Category.class))).thenReturn(category1);
        when(categoryMapper.modelToDto(category1)).thenReturn(categoryDto1);
        when(categoryMapper.dtoToModel(categoryDto1)).thenReturn(category1);


        CategoryDto savedCategory = categoryService.saveCategory(categoryDto1);

        Assertions.assertThat(savedCategory).isNotNull();
        Assertions.assertThat(savedCategory.getCategoryName()).isEqualTo(categoryDto1.getCategoryName());
        Assertions.assertThat(savedCategory.getCategoryId()).isEqualTo(categoryDto1.getCategoryId());
    }

    @Test
    void shouldThrowExceptionIfCategoryAlreadyExist() {

        when(categoryRepository.existsByCategoryName(category2.getCategoryName())).thenReturn(true);

        Assertions.assertThatThrownBy(() -> categoryService.saveCategory(categoryDto2))
                .isInstanceOf(CategoryAlreadyExistException.class)
                .hasMessageContaining(String.format("The category %s is already  exists.", category2.getCategoryName()));

    }

    @Test
    void updateCategory() {

        when(categoryRepository.save(category2)).thenReturn(category2);
        when(categoryMapper.modelToDto(category2)).thenReturn(categoryDto2);
        when(categoryMapper.dtoToModel(categoryDto2)).thenReturn(category2);

        CategoryDto updateReturn = categoryService.updateCategory(categoryDto2);

        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getCategoryName()).isEqualTo(categoryDto2.getCategoryName());
        Assertions.assertThat(updateReturn.getCategoryId()).isEqualTo(categoryDto2.getCategoryId());

    }

    @Test
    void shouldDeleteProductByName() {

        // Arrange
        String category1Name="Book1";

        // Act
        categoryService.deleteCategoryByName(category1Name);

        // Assert
        verify(categoryRepository, times(1)).deleteCategoryByCategoryName(category1Name);
    }


    /**
     *This method contains assertions for a list of CategoryDtos objects.
     *
     *It calls the getAllCAtegories() method from the categoryService to get a list of CategoryDto objects and then
     *asserts that the list is not empty, contains 2 items, and that each item is not null and has the correct name.
     *
     *@param categoryDtoList A list of CategoryDto objects to be tested.
     */
    private void assertCategoryDtoList(List<CategoryDto> categoryDtoList) {

        // Call the service method to get a list of categories dtos
        List<CategoryDto> categoryDtos = categoryDtoList;

        // Assert that the list is not empty
        Assertions.assertThat(categoryDtos).isNotEmpty();
        // Assert that the list contains 2 items
        Assertions.assertThat(categoryDtos.size()).isEqualTo(2);
        // Assert that the first item is not null
        Assertions.assertThat(categoryDtos.get(0)).isNotEqualTo(null);
        // Assert that the second item is not null
        Assertions.assertThat(categoryDtos.get(1)).isNotEqualTo(null);
        // Assert that the name of the first item is the same as the name of the first category
        Assertions.assertThat(categoryDtos.get(0).getCategoryName()).isEqualTo(category1.getCategoryName());
        // Assert that the name of the second item is the same as the name of the second category
        Assertions.assertThat(categoryDtos.get(1).getCategoryName()).isEqualTo(category2.getCategoryName());
    }
}