<%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/20/21
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object travel = request.getParameter("travel");
    Object redirect = request.getParameter("redirect");
    String parameters = "travel=" + travel + "&redirect=" + redirect;
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container mb-2 w-75 m-auto">
    <form method="post" action="userSignUp<%="?"+parameters%>">
        <div class="mb-3">
            <label for="fName" class="form-label">First Name</label>
            <input type="text" class="form-control" name="fName" placeholder="First Name" id="fName">
        </div>
        <div class="mb-3">
            <label for="lName" class="form-label">Last Name</label>
            <input type="text" class="form-control" name="lName" placeholder="last Name" id="lName">
        </div>
        <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            <div id="gender">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="flexRadioDefault1" checked>
                    <label class="form-check-label" for="flexRadioDefault1">
                        Male
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="flexRadioDefault2">
                    <label class="form-check-label" for="flexRadioDefault2">
                        Female
                    </label>
                </div>
            </div>
        </div>
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input autocomplete="false" type="text" class="form-control" name="username" id="username" placeholder="Username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input autocomplete="false" type="password" class="form-control" name="password" id="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
