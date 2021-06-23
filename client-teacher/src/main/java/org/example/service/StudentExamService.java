package org.example.service;

import org.example.entity.Student;
import org.example.entity.StudentExam;
import org.example.entity.Teacher;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;

public interface StudentExamService {
    public PageResult getStudentExamInPage(PageUtil pageUtil, int studentId);
    public PageResult getStudentExamInPageByTeacherId(PageUtil pageUtil, int teacherId);
    public StudentExam getExamInfo(int examId, int studentId);
    public int judge(StudentExam studentExam);
    public int finishExam(int id);
    public int updateTeacher(Student student, Teacher teacher);
    public int deleteExam(Student student);
    public int deleteAnswerByStudent(Student student);
}
