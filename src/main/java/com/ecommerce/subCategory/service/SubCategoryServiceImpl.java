<<<<<<< HEAD
package com.ecommerce.subCategory.service;

import com.ecommerce.subCategory.SubCategory;
import com.ecommerce.subCategory.SubCategoryDto;
import com.ecommerce.subCategory.SubCategoryMapper;
import com.ecommerce.subCategory.SubCategoryRepository;
import com.ecommerce.subCategory.exception.NoSubCategoryFoundException;
import com.ecommerce.subCategory.exception.SubCategoryAlreadyExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService{
    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryMapper subCategoryMapper;


    /**
     * Retrieves all subCategories from the database and returns them as a list of SubCategoryDto objects.
     *
     * @return a list of SubCategoryDto objects representing all subCategories in the database
     */
    @Override
    public List<SubCategoryDto> getAllSubCategories() {
        // Retrieve all subCategories from the database as a list.
        List<SubCategory> subCategories=subCategoryRepository.findAll();
        // Convert the list of SubCategory objects to a list of SubCategoryDto objects and return it.
        if (subCategories.isEmpty()) throw  new NoSubCategoryFoundException("SubCategory list is empty");
        return subCategoryMapper.modelToDtos(subCategories);
    }


    /**
     * Retrieves subCategories by name from the database and returns them as a list of SubCategoryDto objects.
     *
     * @param subCategoryName The name of the subCategory that we will search for in the database
     * @return a list of SubCategoryDto objects representing  subCategories by name in the database
     */
    @Override
    public List<SubCategoryDto> getSubCategoriesByName(String subCategoryName) {
        // Retrieve all subCategories by name from the database as a list.
        List<SubCategory> subCategories=subCategoryRepository.findSubCategoriesBySubCategoryNameLikeIgnoreCase(subCategoryName);
        // Convert the list of SubCategory objects to a list of SubCategoryDto objects and return it.
        if (subCategories.isEmpty()) throw  new NoSubCategoryFoundException("No subCategory found with this name");
        return subCategoryMapper.modelToDtos(subCategories);
    }


    /**
     * Save a subCategory in the database.
     *
     * @param subCategoryDto The subCategory that we will save in the database.
     * @throws SubCategoryAlreadyExistException If the subCategory already exists in the database, a SubCategoryAlreadyExistException will be thrown.
     * @return an object of subCategory that we justalready saved.
     */
    @Override
    public SubCategoryDto saveSubCategory(SubCategoryDto subCategoryDto) {
        // We first check whether the SubCategory already exists in the database. If it exists, a SubCategoryAlreadyExistException will be thrown.
        if(isSubCategoryExist(subCategoryDto.getSubCategoryName()))
            throw new SubCategoryAlreadyExistException(String.format("The subCategory %s is already  exists.", subCategoryDto.getSubCategoryName()));
        return savedSubCategory(subCategoryDto);
    }


    /**
     * Update a subCategory in the database.
     *
     * @param subCategoryDto The subCategory that we will save in the database.
     * @throws SubCategoryAlreadyExistException If the subCategory already exists in the database, a SubCategoryAlreadyExistException will be thrown.
     * @return an object of subCategory that we just saved.
     */
    @Override
    public SubCategoryDto updateSubCategory(SubCategoryDto subCategoryDto) {
        return savedSubCategory(subCategoryDto);
    }

    @Override
    public void deleteSubCategoryByName(String subCategoryName) {
        subCategoryRepository.deleteSubCategoryBySubCategoryName(subCategoryName);
    }


    /**
     * Check if a subCategory exists in the database.
     *
     * @param subCategoryName The name of subCategory that we will check if exists in the database.
     * @return If the subCategory exists, the function returns true, if not, it returns false.
     */
    public boolean isSubCategoryExist(String subCategoryName){
        boolean resp=false;
        boolean isExistSubCategory=subCategoryRepository.existsBySubCategoryName(subCategoryName);
        if(isExistSubCategory) resp=true;
        return resp;
    }


    /**
     * save a subCategory in the database.
     *
     * @param subCategoryDto The  subCategory that we will save in the database.
     * @return the subCategory that we just saved in the database.
     */
    public SubCategoryDto savedSubCategory(SubCategoryDto subCategoryDto){
        return subCategoryMapper.modelToDto(subCategoryRepository.save(subCategoryMapper.dtoToModel(subCategoryDto)));
    }
}
=======
package com.ecommerce.subCategory.service;

import com.ecommerce.subCategory.SubCategory;
import com.ecommerce.subCategory.SubCategoryDto;
import com.ecommerce.subCategory.SubCategoryMapper;
import com.ecommerce.subCategory.SubCategoryRepository;
import com.ecommerce.subCategory.exception.NoSubCategoryFoundException;
import com.ecommerce.subCategory.exception.SubCategoryAlreadyExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService{
    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryMapper subCategoryMapper;

    /**
     * Retrieves all subCategories from the database and returns them as a list of SubCategoryDto objects.
     *
     * @return a list of SubCategoryDto objects representing all subCategories in the database
     */
    @Override
    public List<SubCategoryDto> getAllSubCategories() {
        // Retrieve all subCategories from the database as a list.
        List<SubCategory> subCategories=subCategoryRepository.findAll();
        // Convert the list of SubCategory objects to a list of SubCategoryDto objects and return it.
        if (subCategories.isEmpty()) throw  new NoSubCategoryFoundException("SubCategory list is empty");
        return subCategoryMapper.modelToDtos(subCategories);
    }

    /**
     * Retrieves subCategories by name from the database and returns them as a list of SubCategoryDto objects.
     *
     * @param subCategoryName The name of the subCategory that we will search for in the database
     * @return a list of SubCategoryDto objects representing  subCategories by name in the database
     */
    @Override
    public List<SubCategoryDto> getSubCategoriesByName(String subCategoryName) {
        // Retrieve all subCategories by name from the database as a list.
        List<SubCategory> subCategories=subCategoryRepository.findSubCategoriesBySubCategoryNameLikeIgnoreCase(subCategoryName);
        // Convert the list of SubCategory objects to a list of SubCategoryDto objects and return it.
        if (subCategories.isEmpty()) throw  new NoSubCategoryFoundException("No subCategory found with this name");
        return subCategoryMapper.modelToDtos(subCategories);
    }

    /**
     * Save a subCategory in the database.
     *
     * @param subCategoryDto The subCategory that we will save in the database.
     * @throws SubCategoryAlreadyExistException If the subCategory already exists in the database, a SubCategoryAlreadyExistException will be thrown.
     * @return an object of subCategory that we justalready saved.
     */
    @Override
    public SubCategoryDto saveSubCategory(SubCategoryDto subCategoryDto) {
        // We first check whether the SubCategory already exists in the database. If it exists, a SubCategoryAlreadyExistException will be thrown.
        if(isSubCategoryExist(subCategoryDto.getSubCategoryName()))
            throw new SubCategoryAlreadyExistException(String.format("The subCategory %s is already  exists.", subCategoryDto.getSubCategoryName()));
        return savedSubCategory(subCategoryDto);
    }

    /**
     * Update a subCategory in the database.
     *
     * @param subCategoryDto The subCategory that we will save in the database.
     * @throws SubCategoryAlreadyExistException If the subCategory already exists in the database, a SubCategoryAlreadyExistException will be thrown.
     * @return an object of subCategory that we just saved.
     */
    @Override
    public SubCategoryDto updateSubCategory(SubCategoryDto subCategoryDto) {
        return savedSubCategory(subCategoryDto);
    }
    @Override
    public void deleteSubCategoryByName(String subCategoryName) {
        subCategoryRepository.deleteSubCategoryBySubCategoryName(subCategoryName);
    }
    /**
     * Check if a subCategory exists in the database.
     *
     * @param subCategoryName The name of subCategory that we will check if exists in the database.
     * @return If the subCategory exists, the function returns true, if not, it returns false.
     */
    public boolean isSubCategoryExist(String subCategoryName){
        boolean resp=false;
        boolean isExistSubCategory=subCategoryRepository.existsBySubCategoryName(subCategoryName);
        if(isExistSubCategory) resp=true;
        return resp;
    }
    /**
     * save a subCategory in the database.
     *
     * @param subCategoryDto The  subCategory that we will save in the database.
     * @return the subCategory that we just saved in the database.
     */
    public SubCategoryDto savedSubCategory(SubCategoryDto subCategoryDto){
        return subCategoryMapper.modelToDto(subCategoryRepository.save(subCategoryMapper.dtoToModel(subCategoryDto)));
    }
}
>>>>>>> 3d777e24db8011f284d8443e45ae5a28e61373d3
