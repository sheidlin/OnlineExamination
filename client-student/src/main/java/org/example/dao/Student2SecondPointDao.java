package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.StudentSecondKnowledgePoint;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Student2SecondPointDao {
    int insertKnowledgePoint(StudentSecondKnowledgePoint studentSecondKnowledgePoint);
    int updateKnowledgePoint(StudentSecondKnowledgePoint studentSecondKnowledgePoint);
    List<StudentSecondKnowledgePoint> findKnowledgePointByStudentId(@Param("studentId") Integer studentId);
    StudentSecondKnowledgePoint findKnowledgePointByStudentIdAndPointId(@Param("studentId") Integer studentId, @Param("secondKnowledgePointId") Integer secondKnowledgePointId);
    List<StudentSecondKnowledgePoint> findKnowledgePointByStudentIdAndFirstPointId(@Param("studentId") Integer studentId, @Param("firstKnowledgePointId") Integer firstKnowledgePointId);
}
