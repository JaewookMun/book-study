package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.repository;

import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.Survey;
import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.SurveyAnswer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemorySurveyRepository implements SurveyRepository {
    private Map<Long, Survey> surveys = new ConcurrentHashMap<>();

    @Override
    public void save(Survey survey) {
        surveys.put(survey.getId(), survey);
    }

    @Override
    public Survey findById(Long surveyId) {
        return surveys.get(surveyId);
    }

    @Override
    public SurveyAnswer findBySurveyAndRespondent(Long surveyId, Long respondentId) {
        return surveys.get(surveyId).getResponseList()
                .stream()
                .filter(a -> a.getRespondentId().equals(respondentId))
                .findFirst()
                .orElseThrow();
    }
}
