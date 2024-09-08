package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected;

import java.util.List;

public class SurveyAnswerRequest {
    private Long surveyId;
    private Long respondentId;
    private List<Integer> answers;

    public SurveyAnswerRequest(Long surveyId, Long respondentId, List<Integer> answers) {
        this.surveyId = surveyId;
        this.respondentId = respondentId;
        this.answers = answers;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public Long getRespondentId() {
        return respondentId;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public static SurveyAnswerRequestBuilder builder() {
        return new SurveyAnswerRequestBuilder();
    }

    public static class SurveyAnswerRequestBuilder {
        private Long surveyId;
        private Long respondentId;
        private List<Integer> answers;

        public SurveyAnswerRequestBuilder surveyId(Long surveyId) {
            this.surveyId = surveyId;
            return this;
        }

        public SurveyAnswerRequestBuilder respondentId(Long respondentId) {
            this.respondentId = respondentId;
            return this;
        }

        public SurveyAnswerRequestBuilder answers(List<Integer> answers) {
            this.answers = answers;
            return this;
        }

        public SurveyAnswerRequest build() {
            return new SurveyAnswerRequest(surveyId, respondentId, answers);
        }
    }
}
