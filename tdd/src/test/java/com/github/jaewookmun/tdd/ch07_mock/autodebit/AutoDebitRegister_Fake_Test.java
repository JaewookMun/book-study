package com.github.jaewookmun.tdd.ch07_mock.autodebit;

import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.AutoDebitInfo;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.AutoDebitReq;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.RegisterResult;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.repository.MemoryAutoDebitInfoRepository;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.stub.StubAutoDebitInfoRepository;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.stub.StubCardNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Fake_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator cardNumberValidator;
    private MemoryAutoDebitInfoRepository repository;

    @BeforeEach
    void setUp() {
        cardNumberValidator = new StubCardNumberValidator();
        repository = new MemoryAutoDebitInfoRepository();
        register = new AutoDebitRegister(cardNumberValidator, repository);
    }

    @Test
    void alreadyRegistered_InfoUpdated() {
        repository.save(
                new AutoDebitInfo("user1", "111222333444", LocalDateTime.now()));

        AutoDebitReq req = new AutoDebitReq("user1", "123456789012");
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = repository.findOne("user1");
        assertEquals("123456789012", saved.getCardNumber());
    }

    @Test
    void notYetRegistered_newInfoRegistered() {
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = repository.findOne("user1");
        assertEquals("1234123412341234", saved.getCardNumber());
    }

}
