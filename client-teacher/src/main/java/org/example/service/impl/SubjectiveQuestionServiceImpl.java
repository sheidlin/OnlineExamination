package org.example.service.impl;

import org.example.dao.FirstKnowledgePointDao;
import org.example.dao.SecondKnowledgePointDao;
import org.example.dao.SubjectiveQuestionDao;
import org.example.entity.FirstKnowledgePoint;
import org.example.entity.SecondKnowledgePoint;
import org.example.entity.SubjectiveQuestion;
import org.example.service.SubjectiveQuestionService;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class SubjectiveQuestionServiceImpl implements SubjectiveQuestionService {
    @Autowired
    private SubjectiveQuestionDao subjectiveQuestionDao;
    @Autowired
    private FirstKnowledgePointDao firstKnowledgePointDao;
    @Autowired
    private SecondKnowledgePointDao secondKnowledgePointDao;
    @Override
    public int addSubjectiveQuestion(SubjectiveQuestion subjectiveQuestion) {
        return subjectiveQuestionDao.insertQuestion(subjectiveQuestion);
    }

    @Override
    public int updateSubjectiveQuestion(SubjectiveQuestion subjectiveQuestion) {
        return subjectiveQuestionDao.updateQuestion(subjectiveQuestion);
    }

    @Override
    public int deleteSubjectiveQuestion(int id) {
        return subjectiveQuestionDao.deleteQuestion(id);
    }

    @Override
    public SubjectiveQuestion findSubjectiveQuestionById(int id) {
        return subjectiveQuestionDao.findQuestionById(id);
    }

    @Override
    public PageResult getSubjectiveQuestionInPage(PageUtil pageUtil) {
        List<SubjectiveQuestion> subjectiveQuestionServiceList;
        subjectiveQuestionServiceList=subjectiveQuestionDao.findQuestion(pageUtil);
        for(SubjectiveQuestion subjectiveQuestion : subjectiveQuestionServiceList){
            subjectiveQuestion.wordsListfy();
        }
        int num=subjectiveQuestionDao.findNumOfQuestion(pageUtil);
        PageResult pageResult=new PageResult();
        pageResult.setTotalCount(num);
        pageResult.setCurrentPage(pageUtil.getPage());
        pageResult.setList(subjectiveQuestionServiceList);
        pageResult.setPageSize(pageUtil.getLimit());
        pageResult.setTotalPage((num+pageUtil.getLimit()-1)/pageUtil.getLimit());
        return pageResult;
    }

    @Override
    public int updateKeyWords(SubjectiveQuestion subjectiveQuestion) {
        subjectiveQuestion.wordsStringfy();
        System.out.println(subjectiveQuestion.toString());
        return subjectiveQuestionDao.updateKeyWords(subjectiveQuestion);
    }

    @Override
    public SubjectiveQuestion sloveKnowledgePoint(SubjectiveQuestion subjectiveQuestion) {
        String firstPoint=subjectiveQuestion.getFirstLevelKnowledgePoint();
        String secondPoint=subjectiveQuestion.getSecondLevelKnowledgePoint();
        if(StringUtils.isEmptyOrWhitespace(firstPoint)||StringUtils.isEmptyOrWhitespace(secondPoint))return subjectiveQuestion;
        FirstKnowledgePoint firstKnowledgePoint=firstKnowledgePointDao.findKnowledgePointByKnowledgePoint(firstPoint);
        SecondKnowledgePoint secondKnowledgePoint;
        if(firstKnowledgePoint==null){
            firstKnowledgePoint=new FirstKnowledgePoint(firstPoint);
            firstKnowledgePointDao.insertKnowledgePoint(firstKnowledgePoint);
            firstKnowledgePoint=firstKnowledgePointDao.findKnowledgePointByKnowledgePoint(firstPoint);
        }
        secondKnowledgePoint=secondKnowledgePointDao.findKnowledgePointByKnowledgePointAndFirstPointId(firstKnowledgePoint.getId(),secondPoint);
        if(secondKnowledgePoint==null){
            secondKnowledgePoint=new SecondKnowledgePoint(firstKnowledgePoint.getId(),secondPoint,firstPoint);
            secondKnowledgePointDao.insertKnowledgePoint(secondKnowledgePoint);
            secondKnowledgePoint=secondKnowledgePointDao.findKnowledgePointByKnowledgePointAndFirstPointId(firstKnowledgePoint.getId(),secondPoint);
        }
        subjectiveQuestion.setFirstLevelKnowledgePointId(firstKnowledgePoint.getId());
        subjectiveQuestion.setSecondLevelKnowledgePointId(secondKnowledgePoint.getId());
        return subjectiveQuestion;
    }
}
