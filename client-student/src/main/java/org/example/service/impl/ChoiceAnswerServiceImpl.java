package org.example.service.impl;

import org.example.dao.ChoiceAnswerDao;
import org.example.entity.ChoiceAnswer;
import org.example.service.ChoiceAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceAnswerServiceImpl implements ChoiceAnswerService {
    @Autowired
    private ChoiceAnswerDao choiceAnswerDao;
    @Override
    public int updateAnswer(ChoiceAnswer choiceAnswer) {
        return choiceAnswerDao.updateAnswer(choiceAnswer);
    }
}
