package com.github.jaewookmun.tdd.ch07_mock.autodebit;

import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.AutoDebitReq;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.CardValidity;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.RegisterResult;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.stub.StubAutoDebitInfoRepository;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.stub.StubCardNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.CardValidity.INVALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AutoDebitRegister_Stub_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepository);
    }

    @Test
    void invalidCard() {
        stubValidator.setInvalidNo("111122223333");

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);

        assertEquals(INVALID, result);
    }

    @Test
    void theftCard() {
        stubValidator.setTheftNo("1234567890123456");

        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = this.register.register(req);

        assertEquals(CardValidity.THEFT, result.getValidity());
    }
}