package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.ChoiceQuestion;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface ChoiceQuestionDao {
    int insertQuestion(ChoiceQuestion choiceQuestion);
    int updateQuestion(ChoiceQuestion choiceQuestion);
    int findNumOfQuestion(Map param);
    ChoiceQuestion findQuestionById(@Param("id") Integer id);
    ChoiceQuestion findQuestionByIdSpecialy(@Param("id") Integer id);
    int deleteQuestion(@Param("id") Integer id);
    List<ChoiceQuestion> findQuestion(Map param);
}
