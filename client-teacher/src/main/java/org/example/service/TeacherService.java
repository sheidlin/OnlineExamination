package org.example.service;

import org.example.entity.Teacher;

public interface TeacherService {
    public Teacher findTeacherByToken(String token);
    public Teacher findTeacherById(Teacher teacher);
    public int nameBeRegistered(String userName);
    public Teacher updateTokenAndLogin(Teacher teacher);
    public int addTeacher(Teacher teacher);
}
