package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_set_duplicate_env;

public interface UserService {
    void changeAddress(String id, Address address);

    void changePw(String id, String prevPw, String newPw);
}
