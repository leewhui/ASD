<%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 26/08/2020
  Time: 9:40 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.app.asd.Model.*" %>
<%@page import="com.app.asd.Model.dao.*" %>
<%@ page import="com.app.asd.Utils.JGDBC" %>

<%
    JGDBC jgdbc = new JGDBC();
    adminHomeDao con = new adminHomeDao(jgdbc.openConnection(), "User");
    adminHomeDao conCard = new adminHomeDao(jgdbc.openConnection(), "Card");
    session.setAttribute("con", con);
    session.setAttribute("conCard", conCard);
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
                <li><a href="adminCreateUser.jsp" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">Adding New User</a></li>
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
            <th>activated_status</th>
            <th>Username</th>
            <th>Edition</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (users != null) {
                int i = 0;
                for (User u : users) {
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
                    String activated_status = u.getActivated_status();
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
            <td>
                <!-- 按钮触发模态框 -->
                <button class="btn btn-default btn-xs center-block" data-toggle="modal" data-target="#<%=i%>">
                    Action
                </button>
                <!-- 模态框（Modal） -->

                <div class="modal fade" id="<%=i%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog ">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h3 class="modal-title" id="exampleModalLongTitle">Editing "<%=email%>"</h3>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="editInfoController" method="post">
                                    <input type="hidden" name="type" value="search user">
                                    Editing the Information of User:
                                    <button class="btn btn-default " type="submit" name="userEmail" value="<%=email%>">
                                        Edit Info
                                    </button>
                                </form>

                                <form action="editInfoController" method="post">
                                    <input type="hidden" name="type" value="edit Account search">
                                    Editing the Card of User:&ensp;&ensp;&ensp;&ensp;&ensp;
                                    <button class="btn btn-default " type="submit" name="userEmail" value="<%=email%>">
                                        Edit Card
                                    </button>
                                </form>
                                <form action="editInfoController" method="post">
                                    <input type="hidden" name="type" value="deteing user">
                                    Deleting this User: &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<button
                                        class="btn btn-default " type="submit" name="userEmail" value="<%=email%>"
                                        onclick="return confirm('Are you sure to Delete this user?')">Delete user
                                </button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close
                                </button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
            </td>
        </tr>
        <%
                    i++;
                }
            } else {
                System.out.println("jsp users null");
            }
        %>
        </tbody>
    </table>



</div>
<%} else {%>
<div class="starter">
    <img alt="" src="resources/admin.png" style="margin: 0 auto;"/>
</div>

<%}%>
</body>
</html>
