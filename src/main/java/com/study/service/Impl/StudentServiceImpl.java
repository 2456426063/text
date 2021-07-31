package com.study.service.Impl;

import com.study.dao.StudentDao;
import com.study.entity.Student;
import com.study.service.StudentService;
import com.study.util.SqlsessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {


    private StudentDao dao = SqlsessionUtil.getSqlsession().getMapper(StudentDao.class);


    @Override
    public List<Student> selectStudent() {
        List<Student> list = dao.selectStudent();
        return list;
    }

    @Override
    public int insertStudent(Student student) {
        Integer result = dao.insertStudent(student);
        return result;
    }
}
