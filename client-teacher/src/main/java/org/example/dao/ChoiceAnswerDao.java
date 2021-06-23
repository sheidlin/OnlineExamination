package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.ChoiceAnswer;

import java.util.List;

public interface ChoiceAnswerDao {
    int insertAnswer(ChoiceAnswer choiceAnswer);
    int insertTeacherAnswer(@Param("studentId") Integer studentId, @Param("teacherId") Integer teacherId);
    int deleteStudentAnswer(@Param("studentId") Integer studentId);
    int updateAnswer(ChoiceAnswer choiceAnswer);
    int deleteExam(@Param("examId") Integer examId);
    List<ChoiceAnswer> findAnswerByExamIdAndStudentId(@Param("examId") Integer examId, @Param("studentId") Integer studentId);
}
