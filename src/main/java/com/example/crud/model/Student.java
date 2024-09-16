package com.example.crud.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String className;
    private double point;

    public Student(String name, String email, String className, double point) {
        this.name = name;
        this.email = email;
        this.className = className;
        this.point = point;
    }

    public Student(int id, String name, String email, String className, double point) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.className = className;
        this.point = point;
    }

    // Getters and setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
