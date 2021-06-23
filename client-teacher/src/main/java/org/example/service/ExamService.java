package org.example.service;


import org.example.entity.Exam;
import org.example.utils.ExamUpdUtil;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;

public interface ExamService {
    int addExam(Exam exam);
    Exam getExamById(int id);
    Exam getExamByTitle(String title);
    Exam getExamInfo(Exam exam);
    int updateExam(Exam exam);
    int deleteChoiceQuestion(ExamUpdUtil examUpdUtil);
    int deleteSubjectiveQuestion(ExamUpdUtil examUpdUtil);
    int addChoiceQuestion(ExamUpdUtil examUpdUtil);
    int addSubjectiveQuestion(ExamUpdUtil examUpdUtil);
    int deleteExam(Exam exam);
    PageResult getExamInPage(PageUtil pageUtil, int teacherId);
}
