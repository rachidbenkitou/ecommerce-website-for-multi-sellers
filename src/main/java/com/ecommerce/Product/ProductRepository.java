package com.ecommerce.Product;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface ProductRepository extends MongoRepository<Product,Integer>{

	Optional<List<Product>> findBySubCatgeoryId(String subCategoryName);
	Optional<Product> findByProductName(String productName);
	Optional<Product> deleteByProductName(String productName);
	
	boolean existsByProductName(String productName);

}
