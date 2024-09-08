package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected;

import java.util.List;

public class SurveyAnswer {
    private Long respondentId;
    private List<Integer> answers;

    public SurveyAnswer(Long respondentId, List<Integer> answers) {
        this.respondentId = respondentId;
        this.answers = answers;
    }

    public Long getRespondentId() {
        return respondentId;
    }

    public List<Integer> getAnswers() {
        return answers;
    }
}
