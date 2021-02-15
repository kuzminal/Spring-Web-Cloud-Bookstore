package com.kuzmin.bookstore.repository;

import com.kuzmin.bookstore.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
