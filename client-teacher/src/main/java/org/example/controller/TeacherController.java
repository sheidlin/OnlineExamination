package org.example.controller;


import org.example.common.Constants;
import org.example.common.Result;
import org.example.common.ResultGenerator;
import org.example.config.annotation.TokenToTeacher;
import org.example.entity.Teacher;
import org.example.service.StudentExamService;
import org.example.service.TeacherService;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController{
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentExamService studentExamService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody Teacher teacher) {
        if(teacherService.addTeacher(teacher)>0){
            return ResultGenerator.genSuccessResult();
        }
        else{
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Teacher teacher) {
        Result result = ResultGenerator.genFailResult("FAIL");
        if (StringUtils.isEmpty(teacher.getUserName()) || StringUtils.isEmpty(teacher.getPassword())) {
            ;return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR,"");
        }
        Teacher loginTeacher=teacherService.updateTokenAndLogin(teacher);
        if(loginTeacher==null){
            return result;
        }
        return ResultGenerator.genSuccessResult(loginTeacher);
    }

    @RequestMapping(value = "/exams/list/{id}", method = RequestMethod.GET)
    public Result getStudentExamInPage(@RequestParam Map<String ,Object> param, @PathVariable int id, @TokenToTeacher Teacher teacher){
        if(teacher==null){
            return ResultGenerator.genNotLoginResult();
        }
        if (org.springframework.util.StringUtils.isEmpty(param.get("page")) || org.springframework.util.StringUtils.isEmpty(param.get("limit"))) {
//            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR,"");
            param.put("page","1");
            param.put("limit","10000");
        }
        PageUtil pageUtil=new PageUtil(param);
        pageUtil.put("examId",id);
        PageResult pageResult=studentExamService.getStudentExamInPageByTeacherId(pageUtil,teacher.getId());
        return ResultGenerator.genSuccessResult(pageResult);
    }

}
