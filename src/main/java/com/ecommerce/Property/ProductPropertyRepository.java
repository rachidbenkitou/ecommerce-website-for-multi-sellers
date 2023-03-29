package com.ecommerce.Property;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.Product.Product;

public interface ProductPropertyRepository extends MongoRepository<ProductProperty, String> {


	Optional<List<ProductProperty>> findByProductId(String idProduct);

	Optional<List<ProductProperty>> findByPropertyPropertyId(String idpropert);

	void deleteByProductAndProperty(Product product,Property property);
	
	
}
