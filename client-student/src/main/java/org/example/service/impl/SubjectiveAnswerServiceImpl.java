package org.example.service.impl;

import org.example.dao.SubjectiveAnswerDao;
import org.example.entity.SubjectiveAnswer;
import org.example.service.SubjectiveAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectiveAnswerServiceImpl implements SubjectiveAnswerService {
    @Autowired
    private SubjectiveAnswerDao subjectiveAnswerDao;
    @Override
    public int updateAnswer(SubjectiveAnswer subjectiveAnswer) {
        return subjectiveAnswerDao.updateAnswer(subjectiveAnswer);
    }
}
