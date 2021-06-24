package org.example.service;


import org.example.entity.Student;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;

import java.util.List;

public interface KnowledgePointService {
    public PageResult getStudentFirstKnowledgePoint(PageUtil pageUtil, Student student);
    public PageResult getSecondKnowledgePointByFirstPointId(Student student, int firstPointId);
}
