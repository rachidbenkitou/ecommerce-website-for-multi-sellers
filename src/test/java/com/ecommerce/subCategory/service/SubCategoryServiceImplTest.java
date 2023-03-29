package com.ecommerce.subCategory.service;

import com.ecommerce.subCategory.SubCategory;
import com.ecommerce.subCategory.SubCategoryDto;
import com.ecommerce.subCategory.SubCategoryMapper;
import com.ecommerce.subCategory.SubCategoryRepository;
import com.ecommerce.subCategory.exception.NoSubCategoryFoundException;
import com.ecommerce.subCategory.exception.SubCategoryAlreadyExistException;
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
class SubCategoryServiceImplTest {

    @Mock
    private SubCategoryRepository subCategoryRepository;
    @Mock private SubCategoryMapper subCategoryMapper;
    @InjectMocks
    private SubCategoryServiceImpl subCategoryService;


    private List<SubCategory> subCategories;
    private List<SubCategoryDto> subCategoriesDtos;
    private SubCategory subCategory2;
    private SubCategory subCategory1;
    private SubCategoryDto subCategoryDto1;
    private  SubCategoryDto subCategoryDto2;
    String subCategoryName;
    @BeforeEach
    public void init() {
        subCategoryName="Book";
        subCategory1= SubCategory.builder().subCategoryId("id1").subCategoryName("Book1").build();
        subCategory2= SubCategory.builder().subCategoryId("id2").subCategoryName("Book2").build();
        subCategories= new ArrayList<>();
        subCategories.add(subCategory1);
        subCategories.add(subCategory2);

        subCategoryDto1= SubCategoryDto.builder().subCategoryId("id1").subCategoryName("Book1").build();
        subCategoryDto2= SubCategoryDto.builder().subCategoryId("id2").subCategoryName("Book2").build();
        subCategoriesDtos= new ArrayList<>();
        subCategoriesDtos.add(subCategoryDto1);
        subCategoriesDtos.add(subCategoryDto2);
    }

    @Test
    void shouldReturnListOfSubCategories() {
        // Mock SubCategory repository to return a list of subCategories
        when(subCategoryRepository.findAll()).thenReturn(subCategories);
        // Mock SubCategory mapper to return a list of subCategories dtos
        when(subCategoryMapper.modelToDtos(subCategories)).thenReturn(subCategoriesDtos);
        assertSubCategoryDtoList(subCategoryService.getAllSubCategories());
    }

    @Test
    void shouldReturnListOfSubsubCategoriesByName() {
        when(subCategoryRepository.findSubCategoriesBySubCategoryNameLikeIgnoreCase(subCategoryName)).thenReturn(subCategories);
        // Mock SubCategory mapper to return a list of SubCategory dtos
        when(subCategoryMapper.modelToDtos(subCategories)).thenReturn(subCategoriesDtos);
        assertSubCategoryDtoList(subCategoryService.getSubCategoriesByName(subCategoryName));
    }
    @Test
    void shouldThrowsNoSubCategoryFoundExceptionIfListOfSubCategoriesIsEmpty() {
        // Mock the subSubCategory repository to return an empty list of SubsubCategories
        when(subCategoryRepository.findAll()).thenReturn(Collections.emptyList());

        // Mock the SubCategory repository to return an empty list of SubCategories
        when(subCategoryRepository.findSubCategoriesBySubCategoryNameLikeIgnoreCase(subCategoryName)).thenReturn(Collections.emptyList());

        // Test if NoSubCategoryFoundException is thrown
        Assertions.assertThatThrownBy(() -> subCategoryService.getAllSubCategories())
                .isInstanceOf(NoSubCategoryFoundException.class)
                .hasMessageContaining("SubCategory list is empty");

        // Test if NoSubCategoryFoundException is thrown
        Assertions.assertThatThrownBy(() -> subCategoryService.getSubCategoriesByName(subCategoryName))
                .isInstanceOf(NoSubCategoryFoundException.class)
                .hasMessageContaining("No subCategory found with this name");

        // Verify that the subCategory repository method was called
        verify(subCategoryRepository, times(1)).findAll();

        // Verify that the subCategory repository method was called
        verify(subCategoryRepository, times(1)).findSubCategoriesBySubCategoryNameLikeIgnoreCase(subCategoryName);
    }

    @Test
    void shouldSavesubSubCategory() {
        when(subCategoryRepository.save(Mockito.any(SubCategory.class))).thenReturn(subCategory1);
        when(subCategoryMapper.modelToDto(subCategory1)).thenReturn(subCategoryDto1);
        when(subCategoryMapper.dtoToModel(subCategoryDto1)).thenReturn(subCategory1);


        SubCategoryDto savedsubSubCategory = subCategoryService.savedSubCategory(subCategoryDto1);

        Assertions.assertThat(savedsubSubCategory).isNotNull();
        Assertions.assertThat(savedsubSubCategory.getSubCategoryName()).isEqualTo(subCategoryDto1.getSubCategoryName());
        Assertions.assertThat(savedsubSubCategory.getSubCategoryId()).isEqualTo(subCategoryDto1.getSubCategoryId());
    }

    @Test
    void shouldThrowExceptionIfsubSubCategoryAlreadyExist() {

        when(subCategoryRepository.existsBySubCategoryName(subCategoryDto2.getSubCategoryName())).thenReturn(true);

        Assertions.assertThatThrownBy(() -> subCategoryService.saveSubCategory(subCategoryDto2))
                .isInstanceOf(SubCategoryAlreadyExistException.class)
                .hasMessageContaining(String.format("The subCategory %s is already  exists.", subCategoryDto2.getSubCategoryName()));

    }

    @Test
    void updatesubSubCategory() {

        when(subCategoryRepository.save(subCategory2)).thenReturn(subCategory2);
        when(subCategoryMapper.modelToDto(subCategory2)).thenReturn(subCategoryDto2);
        when(subCategoryMapper.dtoToModel(subCategoryDto2)).thenReturn(subCategory2);

        SubCategoryDto updateReturn = subCategoryService.updateSubCategory(subCategoryDto2);

        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getSubCategoryName()).isEqualTo(subCategoryDto2.getSubCategoryName());
        Assertions.assertThat(updateReturn.getSubCategoryId()).isEqualTo(subCategoryDto2.getSubCategoryId());

    }

    @Test
    void shouldDeleteProductByName() {

        // Arrange
        String subCategory1Name="Book1";

        // Act
        subCategoryService.deleteSubCategoryByName(subCategory1Name);

        // Assert
        verify(subCategoryRepository, times(1)).deleteSubCategoryBySubCategoryName(subCategory1Name);
    }


    /**
     *This method contains assertions for a list of SubCategoryDtos objects.
     *
     *It calls the getAllSubCategories() method from the SubCategoryService to get a list of SubCategoryDto objects and then
     *asserts that the list is not empty, contains 2 items, and that each item is not null and has the correct name.
     *
     *@param SubCategoryDtoList A list of SubCategoryDto objects to be tested.
     */
    private void assertSubCategoryDtoList(List<SubCategoryDto> SubCategoryDtoList) {

        // Call the service method to get a list of SubCategories dtos
        List<SubCategoryDto> SubCategoryDtos = SubCategoryDtoList;

        // Assert that the list is not empty
        Assertions.assertThat(SubCategoryDtos).isNotEmpty();
        // Assert that the list contains 2 items
        Assertions.assertThat(SubCategoryDtos.size()).isEqualTo(2);
        // Assert that the first item is not null
        Assertions.assertThat(SubCategoryDtos.get(0)).isNotEqualTo(null);
        // Assert that the second item is not null
        Assertions.assertThat(SubCategoryDtos.get(1)).isNotEqualTo(null);
        // Assert that the name of the first item is the same as the name of the first SubCategory
        Assertions.assertThat(SubCategoryDtos.get(0).getSubCategoryName()).isEqualTo(subCategory1.getSubCategoryName());
        // Assert that the name of the second item is the same as the name of the second SubCategory
        Assertions.assertThat(SubCategoryDtos.get(1).getSubCategoryName()).isEqualTo(subCategory2.getSubCategoryName());
    }
}