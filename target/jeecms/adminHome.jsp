<%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 26/08/2020
  Time: 9:40 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="com.app.asd.Model.*" %>
<%@page import="com.app.asd.Controller.*" %>
>
<%@page import="com.app.asd.Model.dao.*" %>
<%@ page import="org.bson.types.ObjectId" %>
<%@ page import="com.app.asd.Utils.JGDBC" %>

<%
    JGDBC jgdbc = new JGDBC();
    adminHomeDao con = new adminHomeDao(jgdbc.openConnection());
    session.setAttribute("con",con);
    User[] users = (User[]) request.getAttribute("users");
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminHome</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        body {
            padding-top: 50px;
        }

        .starter {
            padding: 40px 15px;
            text-align: center;
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
                <li ><a href="adminHomeServlet">All User Info</a></li>
                <li><a href="editInfo.jsp" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">User
                    Information edit</a></li>
                <li><
                <li><a href="editAccount.jsp" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">User
                    Account edit</a></li>
            </ul>
            <form class="navbar-form navbar-left form " action="adminHomeController" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" name="userEmail">
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
    <h3>Please select the funtion you want at the top navbar!</h3>
</div>

<HR width="60%" color=#987cb9 SIZE=10>

<%
    if (users != null) {
%>

<h2 class="sub-header">All user information</h2>
<div class="table-responsive">
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>Email</th>
            <th>Password</th>
            <th>First_name</th>
            <th>Last_name</th>
            <th>is_staff</th>
            <th>Phone</th>
            <th>Gender</th>
            <th>Dob</th>
            <th>Data_registered</th>
            <th>Activated_statue</th>
            <th>Username</th>
        </tr>
        </thead>
        <tbody>
        
        <%
            if (users != null) {
                for (User u : users) {
                    String userID = u.getUserId().toString();
                    String password = u.getPassword();
                    String firstName = u.getFirst_name();
                    String lastName = u.getLast_name();
                    String is_staff;
                    if (u.isIs_staff()) {
                        is_staff = "YES";
                    } else {
                        is_staff = "NO";
                    }
                    ;
                    String phone = u.getPhone();
                    String email = u.getEmail();
                    String gender = u.getGender();
                    String dob = u.getDob();
                    String date_registered = u.getDate_registered();
                    String activated_status;
                    if (u.getActivated_status()) {
                        activated_status = "YES";
                    } else {
                        activated_status = "NO";
                    }
                    String username = u.getUsername();
        %>
        <tr>
            <td><%=email%>
            </td>
            <td><%=password%>
            </td>
            <td><%=firstName%>
            </td>
            <td><%=lastName%>
            </td>
            <td><%=is_staff%>
            </td>
            <td><%=phone%>
            </td>
            <td><%=gender%>
            </td>
            <td><%=dob%>
            </td>
            <td><%=date_registered%>
            </td>
            <td><%=activated_status%>
            </td>
            <td><%=username%>
            </td>
        </tr>
        <%
                }
            } else {
                System.out.println("jsp users null");
            }
        %>

        </tbody>
    </table>

    <nav aria-label="Page navigation" class="text-center">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

</div>
<%}%>


</body>
</html>
