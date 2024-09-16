<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Update Student</h1>
    <form action="student-servlet?action=update" method="post" class="form">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${student.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${student.name}" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${student.email}" required><br>
        <label for="className">Class:</label>
        <input type="text" id="className" name="className" value="${student.className}" required><br>
        <label for="point">Point:</label>
        <input type="number" step="0.1" id="point" name="point" value="${student.point}" required><br>
        <button type="submit" class="btn-submit">Update</button>
    </form>
    <a href="student-servlet" class="btn-back">Back to List</a>
</div>
</body>
</html>
