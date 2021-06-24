package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.SubjectiveAnswer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface SubjectiveAnswerDao {
    int insertAnswer(SubjectiveAnswer subjectiveAnswer);
    int insertTeacherAnswer(@Param("studentId") Integer studentId, @Param("teacherId") Integer teacherId);
    int deleteStudentAnswer(@Param("studentId") Integer studentId);
    int deleteExam(@Param("examId") Integer examId);
    int updateAnswer(SubjectiveAnswer subjectiveAnswer);
    List<SubjectiveAnswer> findAnswerByExamIdAndStudentId(@Param("examId") Integer examId, @Param("studentId") Integer studentId);
}
