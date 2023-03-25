package com.ecommerce.Property;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.Product.Product;

public interface ProductPropertyRepository extends MongoRepository<ProductProperty, Long> {

	Optional<List<ProductProperty>> findAllByProduct(Product product);
	boolean deleteAllByProductAndProperty(Product product,Property property);
}
