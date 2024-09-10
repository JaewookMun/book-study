package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_validate_over_two;

import com.github.jaewookmun.tdd.ch07_mock.user.EmailNotifier;
import com.github.jaewookmun.tdd.ch07_mock.user.UserRegister;
import com.github.jaewookmun.tdd.ch07_mock.user.WeakPasswordChecker;
import com.github.jaewookmun.tdd.ch07_mock.user.domain.User;
import com.github.jaewookmun.tdd.ch07_mock.user.repository.MemoryUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 두 개 이상을 검증하지 않기
 */
public class ValidateOverTwoTest {
    private UserRegister userRegister;

    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifier);
    }

    // 리스트 10.5 두가지를 검정하는 코드
    @DisplayName("같은 ID가 없으면 가입에 성공하고 메일을 전송함")
    @Test
    void registerAndSendMail() {
        userRegister.register("id", "pw", "email");

        // 검증 1 : 회원 데이터가 올바르게 저장되었는지 검증
        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());

        // 검증 2 : 이메일 발송을 요청했는지 검증
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        BDDMockito.then(mockEmailNotifier)
                .should().sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email@email.com", realEmail);
    }


    //===========================================================================================


    // 리스트 10.6 각 검증 대상을 별도 테스트로 분리한 코드
    @DisplayName("같은 ID가 없으면 가입 성공함")
    @Test
    void noDupId_RegisterSuccess() {
        userRegister.register("id", "pw", "email");

        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }

    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email@email.com");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        BDDMockito.then(mockEmailNotifier)
                .should().sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email@email.com", realEmail);
    }
}
