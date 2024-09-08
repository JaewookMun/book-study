package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected;

import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.repository.MemorySurveyRepository;
import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.repository.SurveyRepository;
import com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected.service.SurveyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * 변수나 필드를 사용해서 기댓값 표현하지 않기
 */
public class VariablesFieldForExpectedTest {
    private List<Integer> answers = Arrays.asList(1, 2, 3, 4);
    private Long respondentId = 100L;

    private final SurveyRepository surveyRepository;
    private final SurveyService svc;

    public VariablesFieldForExpectedTest() {
        this.surveyRepository = new MemorySurveyRepository();
        this.svc = new SurveyService(surveyRepository);
    }

    /**
     * [10.3] 단언과 객체 생성에 필드와 변수를 사용한 코드
     */
    @DisplayName("답변에 성공하면 결과 저장함")
    @Test
    void saveAnswerSuccessfully() {
        // 답변할 설문이 존재
        Survey survey = SurveyFactory.createApprovedSurvey(1L);
        surveyRepository.save(survey);

        // 설문 답변
        SurveyAnswerRequest surveyAnswer = SurveyAnswerRequest.builder()
                .surveyId(survey.getId())
                .respondentId(respondentId)
                .answers(answers)
                .build();

        svc.answerSurvey(surveyAnswer);

        // 저장결과 확인
        SurveyAnswer savedAnswer = surveyRepository.findBySurveyAndRespondent(
                survey.getId(), respondentId);

        assertAll(
                () -> assertEquals(respondentId, savedAnswer.getRespondentId()),
                () -> assertEquals(answers.size(), savedAnswer.getAnswers().size()),
                () -> assertEquals(answers.get(0), savedAnswer.getAnswers().get(0)),
                () -> assertEquals(answers.get(1), savedAnswer.getAnswers().get(1)),
                () -> assertEquals(answers.get(2), savedAnswer.getAnswers().get(2)),
                () -> assertEquals(answers.get(2), savedAnswer.getAnswers().get(3))
        );
    }

    /**
     * [10.4] 객체 생성과 단어네서 변수 대신 값을 사용
     */
    @DisplayName("답변에 성공하면 결과 저장함")
    @Test
    void saveAnswerSuccessfully1() {
        // 답변할 설문이 존재
        Survey survey = SurveyFactory.createApprovedSurvey(1L);
        surveyRepository.save(survey);

        // 설문 답변
        SurveyAnswerRequest surveyAnswer = SurveyAnswerRequest.builder()
                .surveyId(1L)
                .respondentId(100L)
                .answers(Arrays.asList(1, 2, 3, 4))
                .build();

        svc.answerSurvey(surveyAnswer);

        // 저장결과 확인
        SurveyAnswer savedAnswer = surveyRepository.findBySurveyAndRespondent(1L, 100L);
        assertAll(
                () -> assertEquals(100L, savedAnswer.getRespondentId()),
                () -> assertEquals(4, savedAnswer.getAnswers().size()),
                () -> assertEquals(1, savedAnswer.getAnswers().get(0)),
                () -> assertEquals(2, savedAnswer.getAnswers().get(1)),
                () -> assertEquals(3, savedAnswer.getAnswers().get(2)),
                () -> assertEquals(4, savedAnswer.getAnswers().get(3))
        );
    }
}
