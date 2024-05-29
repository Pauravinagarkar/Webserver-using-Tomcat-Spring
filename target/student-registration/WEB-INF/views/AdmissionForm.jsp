<!DOCTYPE html>
<html>
<head>
    <title>Admission Form</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
</head>
<body>
    <h2>Student Admission Form</h2>
    <form action="submitAdmissionForm" method="post">
        Name: <input type="text" name="name"><br>
        Age: <input type="text" name="age"><br>
        <input type="submit" value="Submit">
    </form>
</body>