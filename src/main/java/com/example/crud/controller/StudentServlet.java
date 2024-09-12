package com.example.crud.controller;

import com.example.crud.model.Student;
import com.example.crud.service.IStudentService;
import com.example.crud.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    private final IStudentService iStudentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "update":
                showUpdateForm(req, resp);
                break;
            case "delete":

                break;
            case "view":

                break;
            default:
                findAll(req,resp);
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("update.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("studentList", iStudentService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNewStudent(req, resp);
                break;
            case "update":

                break;
            case "delete":

                break;
            case "view":

                break;
            default:
                findAll(req,resp);
        }
    }

    private void addNewStudent(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String className = req.getParameter("className");
        double point = Double.parseDouble(req.getParameter("point"));
        Student student = new Student(name, email, className, point);
        iStudentService.addNewStudent(student);
        try {
            resp.sendRedirect("/Gradle___com_example___CRUD_1_0_SNAPSHOT_war/student-servlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

