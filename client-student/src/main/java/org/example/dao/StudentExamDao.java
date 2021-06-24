package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Exam;
import org.example.entity.StudentExam;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentExamDao {
    int insertStudentExam(StudentExam studentExam);
    int updateStudentExam(Exam exam);
    StudentExam findeStudentExamByExamIdAndStudentId(@Param("studentId") Integer studentId, @Param("examId") Integer examId);
    StudentExam findStudentExamById(@Param("id") Integer id);
    List<StudentExam>findStudentExamByStudentId(Map map);
    List<StudentExam>findStudentExamByTeacherId(Map map);//
    int findNumOfExamByStudentId(@Param("studentId") Integer studentId);
    int findNumOfExamByTeacherId(Map map);//
    int deleteStudentExamByExamId(@Param("examId") Integer examId);
    int updateScore(StudentExam studentExam);
    int finishExam(@Param("id") Integer id);
    int deleteExamByStudentId(@Param("studentId") Integer studentId);
    int insertTeacherExam(@Param("studentId") Integer studentId, @Param("teacherId") Integer teacherId);
}
