package com.example.crud.repository;

import com.example.crud.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void addNewStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);  // Accepts ID as parameter to delete
    Student findStudentById(int id); // Finds a student by ID
}
