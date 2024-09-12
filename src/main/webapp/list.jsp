<%--
  Created by IntelliJ IDEA.
  User: BuiNgocLinh
  Date: 30/08/2024
  Time: 10:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- view --> control --> service --> repo --%>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách lớp C0324M4</h1>
<a href="?action=create">Thêm mới học viên</a>
<table border="1">
    <thead>
    <tr>
        <td>Tên</td>
        <td>Email</td>
        <td>Lớp</td>
        <td>Điểm</td>
        <td>Xếp loại</td>
        <td>Chỉnh sửa</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="s">
        <tr>
            <td>${s.name}</td>
            <td>${s.email}</td>
            <td>${s.className}</td>
            <td>${s.point}</td>
            <td>
                <c:choose>
                    <c:when test="${s.point > 9}">Giỏi</c:when>
                    <c:when test="${s.point > 8}">Khá</c:when>
                    <c:otherwise>Trung bình</c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="?action=update">Chỉnh sửa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

