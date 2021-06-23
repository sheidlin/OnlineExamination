package org.example.service.impl;


import org.example.dao.ChoiceQuestionDao;
import org.example.entity.ChoiceQuestion;
import org.example.service.ChoiceQuestionService;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {
    @Autowired
    private ChoiceQuestionDao choiceQuestionDao;

    @Override
    public int addChoiceQuestion(ChoiceQuestion choiceQuestion) {
        return choiceQuestionDao.insertQuestion(choiceQuestion);
    }

    @Override
    public int updateChoiceQuestion(ChoiceQuestion choiceQuestion) {
        return choiceQuestionDao.updateQuestion(choiceQuestion);
    }

    @Override
    public int deleteChoiceQuestion(int id) {
        return choiceQuestionDao.deleteQuestion(id);
    }

    @Override
    public ChoiceQuestion findChoiceQuestionById(int id) {
        return choiceQuestionDao.findQuestionById(id);
    }

    @Override
    public PageResult getChoiceQuestionInPage(PageUtil pageUtil) {
        List<ChoiceQuestion> choiceQuestionList;
        choiceQuestionList=choiceQuestionDao.findQuestion(pageUtil);
        int num=choiceQuestionDao.findNumOfQuestion(pageUtil);
        PageResult pageResult=new PageResult();
        pageResult.setTotalCount(num);
        pageResult.setCurrentPage(pageUtil.getPage());
        pageResult.setList(choiceQuestionList);
        pageResult.setPageSize(pageUtil.getLimit());
        pageResult.setTotalPage((num+pageUtil.getLimit()-1)/pageUtil.getLimit());
        return pageResult;
    }

}
