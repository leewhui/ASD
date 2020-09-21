<%@ page import="com.app.asd.module.User" %><%--
  Created by IntelliJ IDEA.
  User: wenhuili
  Date: 18/8/20
  Time: 1:18 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    String isSignUp = (String) request.getAttribute("isSignUp");
    String status = null;
    String email = "";
    String password = "";
    User user = (User) session.getAttribute("currentUser");
    if (user != null) {
        response.sendRedirect("main.jsp");
    }
    else {
        status = (String) request.getAttribute("LoginStatus");
        Cookie[] cookies = request.getCookies();
        if(cookies != null)
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("email"))
                    email = cookie.getValue();
                else if(cookie.getName().equals("password"))
                    password = cookie.getValue();
            }
    }

%>

<div>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 mb-3 bg-white shadow-sm">
        <a href="" class="logo my-0 mr-md-auto font-weight-normal">
            <img src="resources/logo.png" class="logo my-0 mr-md-auto font-weight-normal" alt="" class="logo">
        </a>
    </div>
</div>
<div class="container">
    <div class="alert alert-primary" role="alert" id="alertBox">
        <%=isSignUp == null ? "" : isSignUp%>
        <%=status == null ? "" : status%>
    </div>
    <form class="form" role="form" action="loginController" method="post">

        <h5>Login</h5>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" aria-describedby="emailHelp" name="email" required value=<%=email%>>
        </div>

        <div class="form-group">
            <label for="passwordBox">Password</label>
            <div class="input-group mb-3">
                <input type="password" class="form-control" aria-label="Recipient's username"
                       aria-describedby="button-addon2" id="passwordBox" name="password" required value=<%=password%>>
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="button" id="showPassword">Show</button>
                </div>
            </div>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="check" name="checkbox">
            <label class="form-check-label" for="check">Remember me</label>
        </div>

        <button type="button" class="btn btn-primary" id="cancelBtn">Cancel</button>
        <button type="submit" class="btn btn-primary" id="submitBtn">Submit</button>
    </form>
</div>
<script>
    const cancelBtn = document.getElementById('cancelBtn');
    const submitBtn = document.getElementById('submitBtn');
    cancelBtn.onclick = function () {
        window.location.href = 'index.jsp';
    };

    document.getElementById('showPassword').onclick = function () {
        showPassword(document.getElementById('showPassword'), 'passwordBox');
    };

    function showPassword(btn, boxName) {
        if (btn.innerHTML === 'Show') {
            document.getElementById(boxName).type = 'text';
            btn.innerHTML = 'Hidden';
        } else {
            document.getElementById(boxName).type = 'password';
            btn.innerHTML = 'Show';
        }
    }

    const alertBox = document.getElementById('alertBox');
    if (alertBox.innerHTML === null)
    {
        alert('ddd')
        alertBox.style.display = 'none';
    }
</script>
</body>
</html>