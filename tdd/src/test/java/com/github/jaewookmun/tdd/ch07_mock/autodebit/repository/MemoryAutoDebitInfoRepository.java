package com.github.jaewookmun.tdd.ch07_mock.autodebit.repository;

import com.github.jaewookmun.tdd.ch07_mock.autodebit.dto.AutoDebitInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * DB 없이 사용 - AutoDebitInfoRepository의 대역 구현
 */
public class MemoryAutoDebitInfoRepository implements AutoDebitInfoRepository {
    private Map<String, AutoDebitInfo> infos = new HashMap<>();

    @Override
    public void save(AutoDebitInfo info) {
        infos.put(info.getUserId(), info);
    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return infos.get(userId);
    }
}
