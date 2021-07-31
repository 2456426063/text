package com.study.controller;

import com.study.entity.Student;
import com.study.service.Impl.StudentServiceImpl;
import com.study.service.StudentService;
import com.study.util.ServiceFactory;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        StudentService service = (StudentService) ServiceFactory.getService(new StudentServiceImpl());

        List<Student> list = service.selectStudent();

        list.forEach(student -> System.out.println(student));
    }
}
