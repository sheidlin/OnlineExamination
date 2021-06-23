package org.example.controller;

import org.example.common.Constants;
import org.example.common.Result;
import org.example.common.ResultGenerator;
import org.example.config.annotation.TokenToTeacher;
import org.example.entity.ChoiceQuestion;
import org.example.entity.Teacher;
import org.example.service.ChoiceQuestionService;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/questions/choice")
public class ChoiceQuestionController {
    @Autowired
    private ChoiceQuestionService choiceQuestionService;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result saveChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion, @TokenToTeacher Teacher teacher){
        if(teacher==null) {
            return ResultGenerator.genNotLoginResult();
        }
        if(choiceQuestionService.addChoiceQuestion(choiceQuestion)>0)return ResultGenerator.genSuccessResult(ResultGenerator.genSuccessResult());
        else return ResultGenerator.genFailResult("");
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result updateChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion, @TokenToTeacher Teacher teacher){
        if(teacher==null) {
            return ResultGenerator.genNotLoginResult();
        }
        if(choiceQuestion.getId()<0){
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR,"NotExist");
        }
        if(choiceQuestionService.updateChoiceQuestion(choiceQuestion)>0)return ResultGenerator.genSuccessResult("SUCCESS");
        else return ResultGenerator.genFailResult("");
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result deleteChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion, @TokenToTeacher Teacher teacher){
        if(teacher==null) {
            return ResultGenerator.genNotLoginResult();
        }
        if(choiceQuestion.getId()<0){
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR,"NotExist");
        }
        if(choiceQuestionService.findChoiceQuestionById(choiceQuestion.getId())==null)return ResultGenerator.genNullResult("IsDeleted");
        if(choiceQuestionService.deleteChoiceQuestion(choiceQuestion.getId())>0)return ResultGenerator.genSuccessResult("SUCCESS");
        else return ResultGenerator.genFailResult("");
    }
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public Result getChoiceQuestion(@PathVariable int id, @TokenToTeacher Teacher teacher){
//        if(teacher==null) {
//            return ResultGenerator.genNotLoginResult();
//        }
        if(id<0) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "NotExist");
        }
        ChoiceQuestion choiceQuestion;
        choiceQuestion=choiceQuestionService.findChoiceQuestionById(id);
        if(choiceQuestion==null)return ResultGenerator.genNullResult("Null");
        else return ResultGenerator.genSuccessResult(choiceQuestion);
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result getChoiceQuestionList(@RequestParam Map<String ,Object> param, @TokenToTeacher Teacher teacher){
        if(teacher==null) {
            return ResultGenerator.genNotLoginResult();
        }
        if (org.springframework.util.StringUtils.isEmpty(param.get("page")) || org.springframework.util.StringUtils.isEmpty(param.get("limit"))) {
//            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR,"");
            param.put("page","1");
            param.put("limit","10000");
        }
        PageUtil pageUtil=new PageUtil(param);
        PageResult pageResult=choiceQuestionService.getChoiceQuestionInPage(pageUtil);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
