package com.example.crud.service;
import com.example.crud.model.Student;
import com.example.crud.repository.IStudentRepository;
import com.example.crud.repository.StudentRepository;
import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        iStudentRepository.addNewStudent(student);
    }
}
