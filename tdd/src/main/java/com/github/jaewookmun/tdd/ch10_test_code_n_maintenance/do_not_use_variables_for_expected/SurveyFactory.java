package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected;

public class SurveyFactory {
    public static Survey createApprovedSurvey(Long surveyId) {
        return new Survey(surveyId);
    }
}
