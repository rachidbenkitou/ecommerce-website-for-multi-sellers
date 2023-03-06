<<<<<<< HEAD
package com.ecommerce.client;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    List<Client> findByFirstName (String name);
    Optional<Client> findByUsername (String name);

}
=======
package com.ecommerce.client;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    List<Client> findByFirstName (String name);

}
>>>>>>> 4fd60159d56d751dc9c3219729c6aec6c20f7c09
