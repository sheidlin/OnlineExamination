package org.example.service.impl;


import org.example.dao.Student2SecondPointDao;
import org.example.entity.FirstKnowledgePoint;
import org.example.entity.Student;
import org.example.entity.StudentSecondKnowledgePoint;
import org.example.service.KnowledgePointService;
import org.example.utils.KnowledgePointUtil;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgePointServiceImpl implements KnowledgePointService {
    @Autowired
    private Student2SecondPointDao student2SecondPointDao;
    @Override
    public PageResult getStudentFirstKnowledgePoint(PageUtil pageUtil, Student student) {
        List<StudentSecondKnowledgePoint>studentSecondKnowledgePoints=student2SecondPointDao.findKnowledgePointByStudentId(student.getId());
        if(studentSecondKnowledgePoints==null) {
            return null;
        }
        List<FirstKnowledgePoint>firstKnowledgePointList=KnowledgePointUtil.seconfToFirst(studentSecondKnowledgePoints);
        PageResult pageResult=new PageResult();
        pageResult.setTotalCount(firstKnowledgePointList.size());
        pageResult.setList(firstKnowledgePointList);
        return pageResult;
    }

    @Override
    public PageResult getSecondKnowledgePointByFirstPointId(Student student,int firstPointId) {
        List<StudentSecondKnowledgePoint>studentSecondKnowledgePointList=student2SecondPointDao.findKnowledgePointByStudentIdAndFirstPointId(student.getId(),firstPointId);
        KnowledgePointUtil.calSecondList(studentSecondKnowledgePointList);
        PageResult pageResult=new PageResult();
        pageResult.setTotalCount(studentSecondKnowledgePointList.size());
        pageResult.setList(studentSecondKnowledgePointList);
        return pageResult;
    }
}
