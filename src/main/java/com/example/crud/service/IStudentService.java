package com.example.crud.service;

import com.example.crud.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void addNewStudent(Student student);

}
