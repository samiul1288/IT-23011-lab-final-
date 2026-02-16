<%@ page import="java.time.LocalDateTime, java.time.format.DateTimeFormatter" %>
<html>
<head>
    <title>Department Information</title>
</head>
<body>

<%
    String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
%>

<h3>Current Date & Time: <%= now %></h3>

<h2>Enter Department Details</h2>

<form method="get" action="TestServlet">

    <label for="deptName">Department Name:</label>
    <input type="text" id="deptName" name="deptName" required>
    <br><br>

    <label for="studentCount">Number of Students:</label>
    <input type="number" id="studentCount" name="studentCount" required>
    <br><br>

    <input type="submit" name="action" value="Insert">
    <input type="submit" name="action" value="View">
    <input type="submit" name="action" value="Update">
    <input type="submit" name="action" value="Delete">

</form>

</body>
</html>
