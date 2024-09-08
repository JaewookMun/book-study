package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected;

import java.util.ArrayList;
import java.util.List;

public class Survey {
    private Long id;
    private List<SurveyAnswer> surveyAnswerList = new ArrayList<>();

    public Survey(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<SurveyAnswer> getResponseList() {
        return surveyAnswerList;
    }
}
