package com.study.service;

import com.study.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectStudent();
    int insertStudent(Student student);
}
