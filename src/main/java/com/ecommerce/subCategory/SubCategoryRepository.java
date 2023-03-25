package com.ecommerce.subCategory;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubCategoryRepository extends MongoRepository<SubCatgeory, String> {
	
	Optional<SubCatgeory> findBySubCategoryName(String subCategoryName);
	
	
}
