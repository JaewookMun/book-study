package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.repository;

import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.Survey;
import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.SurveyAnswer;

public interface SurveyRepository {
    void save(Survey survey);

    SurveyAnswer findBySurveyAndRespondent(Long surveyId, Long respondentId);

    Survey findById(Long surveyId);
}
