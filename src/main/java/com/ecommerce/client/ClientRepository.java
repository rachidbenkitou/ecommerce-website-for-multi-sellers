package com.ecommerce.client;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    List<Client> findByFirstName (String name);
    Optional<Client> findByEmail(String email);
}
