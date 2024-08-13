package com.github.jaewookmun.tdd.ch07_mock.autodebit.repository;

import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.AutoDebitInfo;

public class JpaAutoDebitInfoRepository implements AutoDebitInfoRepository {
    @Override
    public void save(AutoDebitInfo info) {

    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return null;
    }
}
