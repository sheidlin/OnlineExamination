package org.example.service;

import org.example.entity.ChoiceQuestion;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;

public interface ChoiceQuestionService {
    int addChoiceQuestion(ChoiceQuestion choiceQuestion);
    int updateChoiceQuestion(ChoiceQuestion choiceQuestion);
    int deleteChoiceQuestion(int id);
    ChoiceQuestion findChoiceQuestionById(int id);
    PageResult getChoiceQuestionInPage(PageUtil pageUtil);
}
