package org.example.service;

import org.example.entity.Student;

public interface StudentService {
    Student findStudentByToken(String token);
}
