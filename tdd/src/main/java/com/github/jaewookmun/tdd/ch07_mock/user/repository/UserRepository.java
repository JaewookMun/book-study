package com.github.jaewookmun.tdd.ch07_mock.user.repository;

import com.github.jaewookmun.tdd.ch07_mock.user.domain.User;

public interface UserRepository {
    void save(User user);

    User findById(String id);
}
