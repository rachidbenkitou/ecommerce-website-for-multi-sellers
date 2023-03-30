package com.ecommerce.Property;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropertyRepository extends MongoRepository<Property, String> {

	Optional<Property> findByPropertyName(String propertyName);
}

