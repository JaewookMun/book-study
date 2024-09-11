package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_set_duplicate_env;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 리스트 10.10 상황 관련 코드의 중복을 제거한 예
public class SetupDuplicateEnv {

    private ChangeUserService changeService;
    private UserRepository memoryRepository = new MemoryUserRepository();

    @BeforeEach
    void setUp() {
        changeService = new ChangeUserService(memoryRepository);
        memoryRepository.save(
                new User("id", "name", "pw", new Address("서울", "북부"))
        );
    }

    @Test
    void noUser() {
        assertThrows(UserNotFoundException.class,
                () -> changeService.changeAddress("id2", new Address("서울", "남부")));
    }

    @Test
    void changeAddress() {
        changeService.changeAddress("id", new Address("서울", "남부"));

        User user = memoryRepository.findById("id");
        assertEquals("서울", user.getAddress().getCity());
    }

    @Test
    void changePw() {
        changeService.changePw("id", "pw", "newpw");

        User user = memoryRepository.findById("id");
        assertTrue(user.matchPassword("newpw"));
    }

    @Test
    void pwNotMatch() {
        assertThrows(IdPwNotMatchException.class,
                () -> changeService.changePw("id", "pw2", "newpw"));
    }

}
