<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Student</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Create New Student</h1>
    <form action="student-servlet?action=create" method="post" class="form">
        <input type="hidden" name="action" value="create">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="className">Class:</label>
        <input type="text" id="className" name="className" required><br>
        <label for="point">Point:</label>
        <input type="number" step="0.1" id="point" name="point" required><br>
        <button type="submit" class="btn-submit">Create</button>
    </form>
    <a href="student-servlet" class="btn-back">Back to List</a>
</div>
</body>
</html>
