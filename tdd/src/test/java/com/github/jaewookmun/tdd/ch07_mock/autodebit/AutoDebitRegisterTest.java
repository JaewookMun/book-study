package com.github.jaewookmun.tdd.ch07_mock.autodebit;

import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.AutoDebitReq;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.RegisterResult;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.repository.AutoDebitInfoRepository;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.repository.JpaAutoDebitInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.CardValidity.THEFT;
import static com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.CardValidity.VALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 실제 구현을 사용하는 테스트 코드
 */
class AutoDebitRegisterTest {
    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        CardNumberValidator validator = new CardNumberValidator();
        AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
        register = new AutoDebitRegister(validator, repository);
    }

    @Test
    void validCard() {
        // 업체에서 받은 테스트용 유효한 카드번호 사용
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);
        assertEquals(VALID, result.getValidity());
    }

    @Test
    void theftCard() {
        // 업체에서 받은 테스트용 유효한 카드번호 사용
        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = this.register.register(req);
        assertEquals(THEFT, result.getValidity());
    }
}