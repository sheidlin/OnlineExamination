package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.ChoiceAnswer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface ChoiceAnswerDao {
    int insertAnswer(ChoiceAnswer choiceAnswer);
    int insertTeacherAnswer(@Param("studentId") Integer studentId, @Param("teacherId") Integer teacherId);
    int deleteStudentAnswer(@Param("studentId") Integer studentId);
    int updateAnswer(ChoiceAnswer choiceAnswer);
    int deleteExam(@Param("examId") Integer examId);
    List<ChoiceAnswer> findAnswerByExamIdAndStudentId(@Param("examId") Integer examId, @Param("studentId") Integer studentId);
}
