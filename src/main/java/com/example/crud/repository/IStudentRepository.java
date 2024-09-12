package com.example.crud.repository;

import com.example.crud.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void addNewStudent(Student student);
}
