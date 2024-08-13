package com.github.jaewookmun.tdd.ch07_mock.autodebit;

import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.AutoDebitInfo;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.AutoDebitReq;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.CardValidity;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.RegisterResult;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.repository.AutoDebitInfoRepository;

import java.time.LocalDateTime;

public class AutoDebitRegister {
    private CardNumberValidator validator;
    private AutoDebitInfoRepository repository;

    public AutoDebitRegister(CardNumberValidator validator, AutoDebitInfoRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }

    public RegisterResult register(AutoDebitReq req) {
        CardValidity validity = validator.validate(req.getCardNumber());
        if (validity != CardValidity.VALID) {
            return RegisterResult.error(validity);
        }
        AutoDebitInfo info = repository.findOne(req.getUserId());
        if (info != null) {
            info.changeCardNumber(req.getCardNumber());
        } else {
            AutoDebitInfo newInfo =
                    new AutoDebitInfo(req.getUserId(), req.getCardNumber(), LocalDateTime.now());
            repository.save(newInfo);
        }
        return RegisterResult.success();
    }
}
