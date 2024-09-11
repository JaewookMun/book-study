package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_set_duplicate_env;

public interface UserRepository {
    void save(User user);

     User findById(String id);
}
