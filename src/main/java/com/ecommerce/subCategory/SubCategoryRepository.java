package com.ecommerce.subCategory;

import com.ecommerce.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {
    boolean existsBySubCategoryName(String name);
    void deleteSubCategoryBySubCategoryName(String SubCategoryName);
    //List<SubCategory> findSuCategoriesBySuCategoryNameLikeIgnoreCase(String categoryName);
    List<SubCategory> findSubCategoriesBySubCategoryNameLikeIgnoreCase(String categoryName);
<<<<<<< HEAD
    List<SubCategory> findByCategoryCategoryId(String id);
}
=======
    Optional<SubCategory> findBySubCategoryName(String subCategoryName);

}
>>>>>>> 3d777e24db8011f284d8443e45ae5a28e61373d3
