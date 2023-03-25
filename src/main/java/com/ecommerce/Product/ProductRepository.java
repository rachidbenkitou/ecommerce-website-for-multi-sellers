package com.ecommerce.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.subCategory.SubCatgeory;

public interface ProductRepository extends MongoRepository<Product,Long>{

	Optional<List<Product>> findAllBySubCatgeory(SubCatgeory subCatgeory);
}
