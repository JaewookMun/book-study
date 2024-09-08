package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.service;

import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.Survey;
import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.SurveyAnswer;
import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.SurveyAnswerRequest;
import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.repository.SurveyRepository;

public class SurveyService {
    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public void answerSurvey(SurveyAnswerRequest surveyAnswerRequest) {
        Survey survey = surveyRepository.findById(surveyAnswerRequest.getSurveyId());

        survey.getResponseList()
                .add(new SurveyAnswer(
                        surveyAnswerRequest.getRespondentId(),
                        surveyAnswerRequest.getAnswers()));
    }
}
