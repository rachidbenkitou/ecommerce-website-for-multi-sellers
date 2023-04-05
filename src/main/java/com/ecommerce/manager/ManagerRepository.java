package com.ecommerce.manager;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {
    boolean existsManagerByEmail(String email);
    void deleteManagerByEmail(String email);
    List<Manager> findManagersByEmailLikeIgnoreCase(String categoryName);

}
