package org.example.service;

import org.example.entity.SubjectiveQuestion;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;

public interface SubjectiveQuestionService {
    int addSubjectiveQuestion(SubjectiveQuestion subjectiveQuestion);
    int updateSubjectiveQuestion(SubjectiveQuestion subjectiveQuestion);
    int deleteSubjectiveQuestion(int id);
    int updateKeyWords(SubjectiveQuestion subjectiveQuestion);
    SubjectiveQuestion sloveKnowledgePoint(SubjectiveQuestion subjectiveQuestion);
    SubjectiveQuestion findSubjectiveQuestionById(int id);
    PageResult getSubjectiveQuestionInPage(PageUtil pageUtil);
}
