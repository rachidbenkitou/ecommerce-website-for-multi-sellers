package com.ecommerce.seller;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SellerRepository extends MongoRepository<Seller, String> {
    List<Seller> findByFirstName(String firstName);

    Optional<Seller> findByUsername(String username);
}
