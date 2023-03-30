package com.ecommerce.subCategory;

import com.ecommerce.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {
    boolean existsBySubCategoryName(String name);
    void deleteSubCategoryBySubCategoryName(String SubCategoryName);
    //List<SubCategory> findSuCategoriesBySuCategoryNameLikeIgnoreCase(String categoryName);
    List<SubCategory> findSubCategoriesBySubCategoryNameLikeIgnoreCase(String categoryName);
    List<SubCategory> findByCategoryCategoryId(String id);
}
