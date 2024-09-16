package com.example.crud.service;

import com.example.crud.model.Student;
import com.example.crud.repository.IStudentRepository;
import com.example.crud.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private final IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        iStudentRepository.addNewStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        iStudentRepository.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        iStudentRepository.deleteStudent(id);
    }

    @Override
    public Student findStudentById(int id) {
        return iStudentRepository.findStudentById(id);
    }
}
