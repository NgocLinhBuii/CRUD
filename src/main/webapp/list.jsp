<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Student List</h1>
    <a href="student-servlet?action=create" class="btn-create">Add New Student</a>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Class</th>
            <th>Point</th>
            <th>Grade</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="s" items="${studentList}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
                <td>${s.className}</td>
                <td>${s.point}</td>
                <td>
                    <c:choose>
                        <c:when test="${s.point >= 9}">Excellent</c:when>
                        <c:when test="${s.point >= 8}">Good</c:when>
                        <c:otherwise>Average</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="student-servlet?action=update&id=${s.id}" class="btn-action">Edit</a>
                    <a href="student-servlet?action=delete&id=${s.id}" class="btn-action btn-delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
