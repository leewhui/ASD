<%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 26/08/2020
  Time: 9:47 pm
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
                <li><a href="editInfo.jsp" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click',])">User
                    Information edit</a></li>
                <li class="active"><a href="#">User Account edit</a></li>
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
    <h3>Please type in the user ID which you want to edit and press enter</h3>
</div>

<HR width="60%" color=#987cb9 SIZE=10>


<div class="text-center">
    <input placeholder="UserID"></div>

<!-- 按钮触发模态框 -->
<button class="btn btn-primary btn-lg center-block" data-toggle="modal" data-target="#myModal">
    Enter
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>

            </div>
            <div class="modal-body">


                <form action="/demo/demo_form.asp">
                    UserID:<br>
                    <input type="text" name="firstname" value="Mickey">
                    <br>
                    Password:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    First_name:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    Last_name:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    Is_staff:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    Phone:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    Email:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    Gender:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    Dob:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    Data_registered:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    Activated_statue:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    Username:<br>
                    <input type="text" name="lastname" value="Mouse">
                    <br>
                    <br>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Closer
                </button>
                <button type="button" class="btn btn-primary">
                    Enter
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


</div>
</body>
</html>
