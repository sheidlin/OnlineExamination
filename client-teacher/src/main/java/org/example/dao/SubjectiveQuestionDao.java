package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.SubjectiveQuestion;

import java.util.List;
import java.util.Map;

public interface SubjectiveQuestionDao {
    int insertQuestion(SubjectiveQuestion subjectiveQuestion);
    int updateQuestion(SubjectiveQuestion subjectiveQuestion);
    int findNumOfQuestion(Map param);
    SubjectiveQuestion findQuestionById(@Param("id") Integer id);
    SubjectiveQuestion findQuestionByIdSpecialy(@Param("id") Integer id);
    int deleteQuestion(@Param("id") Integer id);
    List<SubjectiveQuestion> findQuestion(Map param);
    int updateKeyWords(SubjectiveQuestion subjectiveQuestion);
}
