<%--
  Created by IntelliJ IDEA.
  User: BuiNgocLinh
  Date: 05/09/2024
  Time: 7:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="?action=create" method="post">
    Tên <input type="text" name="name">
    Email <input type="text" name="email">
    Tên lớp <input type="text" name="className">
    Điểm <input type="number" name="point">
    <input type="submit" value="Thêm mới">
</form>
</body>
</html>
