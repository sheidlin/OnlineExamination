package org.example.controller;


import org.example.common.Result;
import org.example.common.ResultGenerator;
import org.example.config.annotation.TokenToStudent;
import org.example.entity.ChoiceAnswer;
import org.example.entity.Student;
import org.example.entity.SubjectiveAnswer;
import org.example.service.ChoiceAnswerService;
import org.example.service.SubjectiveAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private ChoiceAnswerService choiceAnswerService;
    @Autowired
    private SubjectiveAnswerService subjectiveAnswerService;
    @RequestMapping(value = "/subjective/save",method = RequestMethod.POST)
    public Result saveSubjectiveAnswer(@RequestBody SubjectiveAnswer subjectiveAnswer, @TokenToStudent Student student){
        if(student==null) {
            return ResultGenerator.genNotLoginResult();
        }
        subjectiveAnswer.setScore(0);
        subjectiveAnswer.setStudentId(student.getId());
        if(subjectiveAnswerService.updateAnswer(subjectiveAnswer)>0){
            return ResultGenerator.genSuccessResult();
        }
        else{
            return ResultGenerator.genFailResult("FAIL");
        }
    }
    @RequestMapping(value = "/choice/save",method = RequestMethod.POST)
    public Result saveChoiceAnswer(@RequestBody ChoiceAnswer choiceAnswer, @TokenToStudent Student student){
        if(student==null) {
            return ResultGenerator.genNotLoginResult();
        }
        choiceAnswer.setScore(0);
        choiceAnswer.setQuestionId(student.getId());
        if(choiceAnswerService.updateAnswer(choiceAnswer)>0){
            return ResultGenerator.genSuccessResult();
        }
        else{
            return ResultGenerator.genFailResult("FAIL");
        }
    }
}
