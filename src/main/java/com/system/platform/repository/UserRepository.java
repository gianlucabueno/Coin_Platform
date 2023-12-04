package com.system.platform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.system.platform.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
