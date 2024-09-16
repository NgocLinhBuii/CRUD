package com.example.crud.service;

import com.example.crud.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void addNewStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id); // Accepts ID to delete
    Student findStudentById(int id); // Finds a student by ID  // Finds a student by ID
}

