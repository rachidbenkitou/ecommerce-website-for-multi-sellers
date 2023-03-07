package com.ecommerce.category;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {
    boolean existsByCategoryName(String name);
    void deleteCategoryByCategoryName(String categoryName);

    //List<Category> findCategoriesByCategoryName(String categoryName);
    List<Category> findCategoriesByCategoryNameLikeIgnoreCase(String categoryName);

}
