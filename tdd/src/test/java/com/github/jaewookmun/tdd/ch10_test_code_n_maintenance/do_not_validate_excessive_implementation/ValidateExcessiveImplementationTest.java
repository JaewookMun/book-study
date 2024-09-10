package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_validate_excessive_implementation;

import com.github.jaewookmun.tdd.ch07_mock.user.EmailNotifier;
import com.github.jaewookmun.tdd.ch07_mock.user.UserRegister;
import com.github.jaewookmun.tdd.ch07_mock.user.WeakPasswordChecker;
import com.github.jaewookmun.tdd.ch07_mock.user.repository.MemoryUserRepository;
import com.github.jaewookmun.tdd.ch07_mock.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

/**
 * 과도하게 구현 검증하지 않기
 */
public class ValidateExcessiveImplementationTest {
    private UserRegister userRegister;

    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, mockUserRepository, mockEmailNotifier);
    }

    @DisplayName("회원 가입시 암호 검사 수행함")
    @Test
    void checkPassword() {
        userRegister.register("id", "pw", "email");

        // PasswordChecker#checkPasswordWeak() 메서드 호출 여부 검사
        BDDMockito.then(mockPasswordChecker)
                .should()
                .checkPasswordWeak(Mockito.anyString());

        // UserRepository#findById() 메서드를 호출하지 않는 것을 검사
        BDDMockito.then(mockUserRepository)
                .should()
                .findById(Mockito.anyString());
    }
}
