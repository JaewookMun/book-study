package com.github.jaewookmun.tdd.ch07_mock.autodebit.stub;

import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.AutoDebitInfo;
import com.github.jaewookmun.tdd.ch07_mock.autodebit.repository.AutoDebitInfoRepository;

public class StubAutoDebitInfoRepository implements AutoDebitInfoRepository {
    @Override
    public void save(AutoDebitInfo info) {

    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return null;
    }
}
