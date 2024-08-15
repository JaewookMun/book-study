package com.github.jaewookmun.tdd.ch07_mock.autodebit.repository;

import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.AutoDebitInfo;

public interface AutoDebitInfoRepository {
    void save(AutoDebitInfo info);
    AutoDebitInfo findOne(String userId);
}
