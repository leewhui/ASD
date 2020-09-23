<%@ page import="com.app.asd.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 2020/8/26
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>User Information</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/userInfo.css">
</head>
<body>
<% User user = (User) session.getAttribute("currentUser"); %>
<% Boolean success = (Boolean) request.getAttribute("success"); %>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h3 class="m0 text-bold"><%=user.getUsername()%></h3>
                    <p>Hello, Have fun!</p>
                    <div class="text-center"><a class="btn btn-primary" href="linkCard.jsp">Link Card</a></div>
                </div>
            </div>

            <div class="card mt-3">
                <div class="card-header">
                    Card Info
                    <button class="btn btn-sm btn-danger float-right">Unlink</button>
                </div>
                <div class="card-body">
                    <table class="table">
                        <tr>
                            <th scope="row">Card Number:</th>
                            <td><%=user.getCardNumber()%></td>
                        </tr>
                        <tr>
                            <th scope="row">Card Name:</th>
                            <td>Jack Tom</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <% if(success!=null && success) {
                %>
                <div class="alert alert-success">The user has been saved successfully.</div>
            <%
            } %>
            <div class="card">
                <div class="card-header text-center bg-info text-light text-weight-bold"><h4>User Profile</h4></div>
                <div class="card-body">
                    <form class="form-horizontal" action="editProfile" method="POST">
                        <div class="form-group row">
                            <label class="col-sm-4 control-label">First Name</label>
                            <div class="col-sm-8">
                                <input class="form-control" name="firstName" type="text"
                                       value="<%=user.getFirst_name()%>">
                            </div>

                        </div>
                        <div class="form-group row">
                            <label class="col-sm-4 control-label">Last Name</label>
                            <div class="col-sm-8">
                                <input class="form-control" name="lastName" type="text"
                                       value="<%=user.getLast_name()%>">
                            </div>

                        </div>
                        <div class="form-group row">
                            <label class="col-sm-4 control-label" >Email</label>
                            <div class="col-sm-8">
                                <input class="form-control" name="email" type="email"
                                       value="<%=user.getEmail()%>">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-4 control-label" >Password</label>
                            <div class="col-sm-8">
                                <input class="form-control" name="password" type="text" value="*********">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-4 control-label" >Date of birth</label>
                            <div class="col-sm-8">
                                <input class="form-control" name="dob" type="text" value="<%=user.getDob()%>">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-4 control-label" >Gender</label>
                            <div class="col-sm-8">
                                <input class="form-control" name="gender" type="text"
                                       value="<%=user.getGender()%>">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button class="btn btn-info" type="submit">Update</button>
                            </div>
                        </div>
                    </form>
                    <div class="text-right"><a class="btn btn-primary" href="/main.jsp">Main Page</a></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
