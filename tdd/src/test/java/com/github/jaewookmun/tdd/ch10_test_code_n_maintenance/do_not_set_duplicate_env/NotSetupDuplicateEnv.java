package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_set_duplicate_env;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 리스트 10.11 각 테스트 메서드가 자신에 맞게 상황을 설정하는 코드
public class NotSetupDuplicateEnv {

    private ChangeUserService changeService;
    private UserRepository memoryRepository = new MemoryUserRepository();

    @BeforeEach
    void setUp() {
        changeService = new ChangeUserService(memoryRepository);
    }

    @Test
    void noUser() {
        assertThrows(UserNotFoundException.class,
                () -> changeService.changeAddress("id", new Address("서울", "남부")));
    }

    @Test
    void changeAddress() {
        memoryRepository.save(
                new User("id", "name", "pw", new Address("서울", "북부"))
        );
        
        changeService.changeAddress("id", new Address("경기", "남부"));

        User user = memoryRepository.findById("id");
        assertEquals("경기", user.getAddress().getCity());
    }

    @Test
    void changePw() {
        memoryRepository.save(
                new User("id", "name", "oldpw", new Address("서울", "북부"))
        );

        changeService.changePw("id", "oldpw", "newpw");

        User user = memoryRepository.findById("id");
        assertTrue(user.matchPassword("newpw"));
    }

    @Test
    void pwNotMatch() {
        assertThrows(IdPwNotMatchException.class,
                () -> changeService.changePw("id", "pw2", "newpw"));
    }

}
