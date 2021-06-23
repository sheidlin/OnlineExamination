package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Exam;

import java.util.List;
import java.util.Map;

public interface ExamDao {
    int insertExam(Exam exam);
    int deleteExam(@Param("id") Integer id);
    Exam findExamById(@Param("id") Integer id);
    Exam findExamByTitle(@Param("title") String title);
    List<Exam> findExamByTeacherId(Map param);
    List<Exam> findExam(Map param);
    int findNumOfExamByTeacherId(Map param);
    int findNumOfExam();
    int updateExam(Exam exam);
    int deleteChoiceQuestion(@Param("examId") Integer examId);
    int deleteSubjectiveQuestion(@Param("examId") Integer examId);
    int addChoiceQuestion(@Param("examId") Integer examId);
    int addSubjectiveQuestion(@Param("examId") Integer examId);
}
