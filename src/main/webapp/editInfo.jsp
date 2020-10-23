<%@ page import="com.app.asd.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 26/08/2020
  Time: 9:48 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminHome</title>
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
                <li><a href="adminHomeServlet" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">All User
                    Info</a></li>
                <li><a href="adminCreateUser.jsp" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">Adding New User</a></li>
                <li class="active"><a href="#">User Information edit</a></li>
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
    <h3>Please type in the user ID which you want to edit and press enter</h3>
</div>

<HR width="60%" color=#987cb9 SIZE=10>
<br>

<form action="editInfoController" method="post">
    <input type="hidden" name="type" value="search user">
    <div class="text-center">
        <input placeholder="User Email" name="userEmail" required="required">
        <button type="submit">
            Enter
        </button>
    </div>
</form>

<%
    User finded = (User) request.getAttribute("finded");
    String type = (String)request.getAttribute("type");
    if (finded != null) {
%>

<br>
<HR width="60%" color=#987cb9 SIZE=10>
<br>

<h2 class="sub-header">Searched result of "<%=finded.getEmail()%>"</h2>
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
            String password = finded.getPassword();
            String firstName = finded.getFirst_name();
            String lastName = finded.getLast_name();
            String is_staff;
            if (finded.isIs_staff()) {
                is_staff = "YES";
            } else {
                is_staff = "NO";
            }
            ;
            String phone = finded.getPhone();
            String email = finded.getEmail();
            String gender = finded.getGender();
            String dob = finded.getDob();
            String date_registered = finded.getDate_registered();
            String activated_status = finded.getActivated_status();
            String username = finded.getUsername();
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
        </tbody>
    </table>

</div>

<br>
<HR width="60%" color=#987cb9 SIZE=10>
<br>
<form action="editInfoController" method="post">
    <table class="table  table-bordered table-responsive table-curved" style="width: 55%; height: auto;" align="center">
        <tbody>

        <tr>
            <td align="left" style="width: 40%">Email:</td>
            <td style="width: 60%"><%=email%>
            </td>
            <input type="hidden" name="email" style="width: 100%" value="<%=email%>" required="required">
        </tr>
        <tr>
            <td align="left" style="width: 40%">Password:</td>
            <td style="width: 60%"><input type="text" name="password" style="width: 100%" value="<%=password%>" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">First Name:</td>
            <td style="width: 60%"><input type="text" name="firstname" style="width: 100%" value="<%=firstName%>" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Last Name:</td>
            <td style="width: 60%"><input type="text" name="lastname" style="width: 100%" value="<%=lastName%>" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Is Staff:</td>
            <td style="width: 60%"><%if (finded.isIs_staff()) {%>
                NO: <input type="radio" name="is_staff" value="NO"> &ensp;&ensp; YES: <input type="radio" name="is_staff"
                                                                                          value="YES" checked>
                <%} else {%>
                NO: <input type="radio" name="is_staff" value="NO" checked> &ensp;&ensp; YES: <input type="radio"
                                                                                                  name="is_staff"
                                                                                                  value="YES">
                <%}%></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Phone:</td>
            <td style="width: 60%"><input type="text" name="phone" style="width: 100%" value="<%=phone%>" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Gender:</td>
            <td style="width: 60%"><input type="text" name="gender" style="width: 100%" value="<%=gender%>" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Dob:</td>
            <td style="width: 60%"><input type="text" name="dob" style="width: 100%" value="<%=dob%>" required="required"></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Date registered:</td>
            <td style="width: 60%"><%=date_registered%>
            </td>
            <input type="hidden" name="date" style="width: 100%" value="<%=date_registered%>" required="required">
        </tr>
        <tr>
            <td align="left" style="width: 40%">Activated Statue:</td>
            <td style="width: 60%"><%if (finded.getActivated_status().equals("YES")) {%>
                NO: <input type="radio" name="act" value="NO"> &ensp;&ensp; YES: <input type="radio" name="act"
                                                                                             value="YES"
                                                                                             checked>
                <%} else {%>
                NO: <input type="radio" name="act" value="NO" checked> &ensp;&ensp; YES: <input type="radio"
                                                                                                     name="act"
                                                                                                     value="YES">
                <%}%></td>
        </tr>
        <tr>
            <td align="left" style="width: 40%">Username:</td>
            <td style="width: 60%"><input type="text" name="username" style="width: 100%" value="<%=username%>" required="required"></td>
        </tr>
        </tbody>
    </table>
    </div>
    <input type="hidden" name="userEmail" value="<%=email%>">
    <input type="hidden" name="type" value="editing user">
    <div class="text-center">
        <button class="btn btn-default" type="button" onclick="window.location.href = 'editInfo.jsp'">Cancel</button>
        <button class="btn btn-info" type="submit" onclick="return confirm('Are you sure to edit this user?')">Submit</button>
    </div>
</form>
<%}else if(type != null && type.equals("good")){%>

<br>
<h1 class="text-center">Edition finished!</h1>

<%}%>
</body>
</html>
