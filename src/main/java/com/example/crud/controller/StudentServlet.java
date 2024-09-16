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
                deleteStudent(req, resp);
                break;
            case "view":
                // Add code if needed
                break;
            default:
                findAll(req, resp);
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idParam = req.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                throw new NumberFormatException("ID parameter is missing.");
            }

            int id = Integer.parseInt(idParam);
            Student student = iStudentService.findStudentById(id);

            if (student != null) {
                req.setAttribute("student", student);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("update.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Student not found.");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
                requestDispatcher.forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Invalid student ID format.");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);
    }


    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(req, resp);
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
                updateStudent(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            case "view":
                findAll(req, resp);
                break;
            default:
                findAll(req, resp);
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            iStudentService.deleteStudent(id);
            // Chuyển hướng đến trang danh sách sinh viên sau khi xóa
            resp.sendRedirect("student-servlet");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }



    private void addNewStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String className = req.getParameter("className");
        double point = Double.parseDouble(req.getParameter("point"));
        Student student = new Student(name, email, className, point);
        iStudentService.addNewStudent(student);
        resp.sendRedirect("student-servlet");
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String className = req.getParameter("className");
            double point = Double.parseDouble(req.getParameter("point"));
            Student student = new Student(id, name, email, className, point);
            iStudentService.updateStudent(student);
            resp.sendRedirect("student-servlet");
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Invalid input format.");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
            try {
                requestDispatcher.forward(req, resp);
            } catch (ServletException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            req.setAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
            try {
                requestDispatcher.forward(req, resp);
            } catch (ServletException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
