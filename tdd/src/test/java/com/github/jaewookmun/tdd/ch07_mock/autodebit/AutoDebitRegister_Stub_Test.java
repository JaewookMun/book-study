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

        Assertions.assertEquals(INVALID, result);
    }
}