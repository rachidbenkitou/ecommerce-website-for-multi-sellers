package com.ecommerce.subCategory;

import com.ecommerce.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {
    boolean existsBySubCategoryName(String name);
    void deleteSubCategoryBySubCategoryName(String SubCategoryName);
    //List<SubCategory> findSuCategoriesBySuCategoryNameLikeIgnoreCase(String categoryName);
    List<SubCategory> findSubCategoriesBySubCategoryNameLikeIgnoreCase(String categoryName);
    Optional<SubCategory> findBySubCategoryName(String subCategoryName);

}
