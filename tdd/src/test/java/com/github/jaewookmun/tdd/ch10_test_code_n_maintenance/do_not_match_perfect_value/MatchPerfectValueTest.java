package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_match_perfect_value;

import com.github.jaewookmun.tdd.ch07_mock.user.EmailNotifier;
import com.github.jaewookmun.tdd.ch07_mock.user.UserRegister;
import com.github.jaewookmun.tdd.ch07_mock.user.WeakPasswordChecker;
import com.github.jaewookmun.tdd.ch07_mock.user.exception.WeakPasswordException;
import com.github.jaewookmun.tdd.ch07_mock.user.repository.MemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchPerfectValueTest {
    private UserRegister userRegister;

    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifier);
    }

    // 정확하게 일치하는 상황을 정의한 모의 객체
    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw"))
                .willReturn(true);

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }

    // 정확한 값이 아니라 임의의 값에 일치하도록 모의 객체 지정
    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword2() {
        BDDMockito
                .given(mockPasswordChecker.checkPasswordWeak(Mockito.anyString()))
                .willReturn(true);

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }
}
