package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeacherDao {
    int insertTeacher(Teacher teacher);
    int deleteTeacher(@Param("id") Integer id);
    Teacher findTeacherById(@Param("id") Integer id);
    Teacher findTeacherByName(@Param("name") String name);
    Teacher findTeacherByToken(@Param("token") String token);
    Teacher findTeacherByNameAndPassword(@Param("userName") String userName, @Param("password") String password);
    List<Teacher> findTeacher(Map param);
    int findNumOfTeacher(Map param);
    int updateTeacher(Teacher teacher);
    int updateTeacherToken(@Param("id") Integer id, @Param("token") String token);
}
