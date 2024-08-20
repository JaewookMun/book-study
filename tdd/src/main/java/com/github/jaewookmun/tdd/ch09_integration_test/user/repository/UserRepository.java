package com.github.jaewookmun.tdd.ch09_integration_test.user.repository;

import com.github.jaewookmun.tdd.ch09_integration_test.user.domain.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, String> {
    void save(User user);

    User findById(String id);
}
