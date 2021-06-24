package org.example.service;


import org.example.entity.Student;
import org.example.utils.PageResult;
import org.example.utils.PageUtil;

public interface StudentService {
    public Student findStudentByToken(String token);
    public PageResult getStudentInPage(PageUtil pageUtil, int teacherId);
    public int nameBeRegistered(String userName);
    public int addStudent(Student student);
    public Student updateTokenAndLogin(Student student);
    public int deleteStudent(int id);
    public int deleteStudentTeacher(Student student);
    public Student findStudentById(int id);
    public Student findStudentBySno(String sno);
    public int updateStudent(Student student);
    public Student StudentConfirm(Student student);
    public int updatePassword(Student student);
    public Student findStudentByEmail(String email);
}
