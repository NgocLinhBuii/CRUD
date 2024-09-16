package com.example.crud.repository;

import com.example.crud.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String FIND_ALL = "SELECT * FROM student";
    private static final String ADD_STUDENT = "INSERT INTO student(name, email, className, point) VALUES (?, ?, ?, ?)";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE id = ?";
    private static final String UPDATE_STUDENT = "UPDATE student SET name = ?, email = ?, className = ?, point = ? WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM student WHERE id = ?";

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getClassName());
            preparedStatement.setDouble(4, student.getPoint());
            preparedStatement.setInt(5, student.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("No student found with ID: " + student.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating student.", e);
        }
    }

    @Override
    public void deleteStudent(int id) {
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting student.", e);
        }
    }

    @Override
    public Student findStudentById(int id) {
        Student student = null;
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("class_name"),
                            resultSet.getDouble("point")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding student by ID.", e);
        }
        return student;
    }
}
