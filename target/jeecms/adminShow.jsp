<%@ page import="com.app.asd.module.User" %><%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 26/08/2020
  Time: 9:40 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminHome</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        body {
            padding-top: 50px;
        }

        .starter{
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
                <li class="active" ><a href="adminHomeServlet">All User Info</a> </li>
                <li><a href="editInfo.jsp" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">User Information edit</a> </li>
                <li><<li><a href="editAccount.jsp" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">User Account edit</a> </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default" id="submitBtn">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="jsp/main.jsp">Main Page</a></li>
                <li><a href="index.jsp">Logout</a></li>
            </ul>
        </div>


    </div>
</nav>


<div class="starter">
    <h1>Welcome! Administrators.</h1>
    <h3>The search result is presented below</h3>
</div>

<HR  width="60%"color=#987cb9 SIZE=10>


<%User finded = (User)request.getAttribute("finded");
if(finded != null){
%>


<h2 class="sub-header">Searched result of "<%=finded.getUserId()%>"</h2>
<div class="table-responsive">
    <table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>UserID</th>
        <th>Password</th>
        <th>First_name</th>
        <th>Last_name</th>
        <th>is_staff</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Dob</th>
        <th>Data_registered</th>
        <th>Activated_statue</th>
        <th>Username</th>
    </tr>
    </thead>

    <tbody>
    <%
        String userID = finded.getUserId().toString();
        String password = finded.getPassword();
        String firstName = finded.getFirst_name();
        String lastName = finded.getLast_name();
        String is_staff;
        if(finded.isIs_staff()){is_staff = "YES";}else{is_staff = "NO";};
        String phone = finded.getPhone();
        String email = finded.getEmail();
        String gender = finded.getGender();
        String dob = finded.getDob();
        String date_registered = finded.getDate_registered();
        String activated_status;
        if(finded.getActivated_status()){activated_status = "YES";}else{activated_status = "NO";}
        String username = finded.getUsername();
    %>
    <tr>
        <td><%=userID%></td>
        <td><%=password%></td>
        <td><%=firstName%></td>
        <td><%=lastName%></td>
        <td><%=is_staff%></td>
        <td><%=phone%></td>
        <td><%=email%></td>
        <td><%=gender%></td>
        <td><%=dob%></td>
        <td><%=date_registered%></td>
        <td><%=activated_status%></td>
        <td><%=username%></td>
    </tr>



    </tbody>
    </table>

</div>
<%} else{%>

<h2>Could not find that ID</h2>

<%}%>

</body>
</html>
