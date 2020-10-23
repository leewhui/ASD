<%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 26/08/2020
  Time: 9:40 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String type = (String) request.getAttribute("type");
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminHome</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            padding-top: 50px;
        }

        .starter {
            padding: 40px 15px;
            text-align: center;
        }

        .modal-dialog {
            position: absolute !important;
            top: 50% !important;
            left: 50% !important;
            transform: translate(-50%, -50%) !important;
            -webkit-transform: translate(-50%, -50%) !important;
            -moz-transform: translate(-50%, -50%) !important;
            -ms-transform: translate(-50%, -50%) !important;
            -o-transform: translate(-50%, -50%) !important;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">System Admin</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="adminHomeServlet">All User Info</a></li>
                <li class="active"><a href="adminCreateUser.jsp" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">Adding New User</a></li>
                <li><a href="editInfo.jsp" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">User
                    Information edit</a></li>
                <li><a href="editAccount.jsp" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">Users'
                    Card edit</a></li>
            </ul>
            <form class="navbar-form navbar-left form " action="adminHomeController" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" name="userEmail" required="required">
                </div>
                <button type="submit" class="btn btn-default" id="submitBtn">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-right form" action="logoutServlet" method="get">
                    <button type="submit" class="btn btn-default">Logout</button>
                </form>
            </ul>
        </div>
    </div>
</nav>

<div class="starter">
    <h1>Welcome! Administrators.</h1>
    <h3>Please fill in the information of the user which you want to create!</h3>
</div>

<HR width="60%" color=#987cb9 SIZE=10>


    <%
    if(type == null){
%>

<br>

<form action="editInfoController" method="post">

    <table class="table  table-bordered table-responsive table-curved" style="width: 55%; height: auto;" align="center">
        <tbody>
        <tr>
            <td align="left" style="width: 40%">Email:</td>
            <td style="width: 60%"><input type="text" name="userEmail" style="width: 100%" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Password:</td>
            <td style="width: 60%"><input type="text" name="password" style="width: 100%" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">First Name:</td>
            <td style="width: 60%"><input type="text" name="firstname" style="width: 100%" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Last Name:</td>
            <td style="width: 60%"><input type="text" name="lastname" style="width: 100%" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Is Staff:</td>
            <td style="width: 60%">
                NO: <input type="radio" name="is_staff" value="NO">
                &ensp;YES: <input type="radio" name="is_staff" value="YES">
            </td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Phone:</td>
            <td style="width: 60%"><input type="text" name="phone" style="width: 100%" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Gender:</td>
            <td style="width: 60%"><input type="text" name="gender" style="width: 100%" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Dob:</td>
            <td style="width: 60%"><input type="text" name="dob" placeholder="DD/MM/YYYY" style="width: 100%" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Activated Statue:</td>
            <td style="width: 60%">
                NO: <input type="radio" name="act" value="NO">
                &ensp;YES: <input type="radio" name="act" value="YES">
            </td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Username:</td>
            <td style="width: 60%"><input type="text" name="username" style="width: 100%" required="required"></td>
        </tr>
        </tbody>
    </table>

    <div class="text-center">
        <input type="hidden" name="type" value="adding user">
        <button class="btn btn-default" type="button" onclick="window.location.href = 'adminHome.jsp'">Cancel</button>
        <button class="btn btn-info" type="submit" onclick="return confirm('Are you sure to Create this user?')">
            Submit
        </button>
    </div>

    <%
    } else if (type != null && type.equals("good")) {
    %>
    <br>
    <h1 class="starter"> User has been created!!!</h1>
    <%}%>

</form>