package com.example.crud.repository;

import com.example.crud.model.Student;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    List<Student> studentList = new ArrayList<>();
    private BaseRepository baseRepository = new BaseRepository();
    private static final String FIND_ALL = "SELECT * FROM student";
    private static final String ADD_STUDENT = "insert into student(name,email,className,point) value (?,?,?,?)";


    @Override
    public List<Student> findAll() {
        Connection connection = baseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String className = resultSet.getString("className");
                double point = resultSet.getDouble("point");
                studentList.add(new Student(id, name, email, className, point));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return studentList;
    }

    @Override
    public void addNewStudent(Student student) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getClassName());
            preparedStatement.setDouble(4, student.getPoint());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
