<%--
  Created by IntelliJ IDEA.
  User: wenhuili
  Date: 18/8/20
  Time: 3:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign up</title>
    <link rel="stylesheet" href="./css/signup.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <style>
        #second{
            display: none;
        }
    </style>

    <link rel="stylesheet" id=cal_style type="text/css" href="./css/flatpickr.min.css">

</head>
<body>
<div>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 mb-3 bg-white shadow-sm">
        <a href="" class="logo my-0 mr-md-auto font-weight-normal">
            <img src="./resources/logo.png" class="logo my-0 mr-md-auto font-weight-normal" alt="" class="logo">
        </a>
    </div>
</div>
<div class="container">
    <div id="test" class="test"></div>
    <form class="form" action="./login.jsp" method="post">
        <div class="progress">
            <div id="progressBar" class="progress-bar" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <br>
        <h5>Sign Up</h5>

        <div class="pages" id="first">

            <div class="form-group" id="usernameArea">
                <label>Username</label>
                <input type="text" class="form-control" id="usernameBox" aria-describedby="emailHelp" required>
                <small id="usernameText" class="form-text text-warning"></small>
            </div>

            <div class="form-group">
                <label>Email address</label>
                <input type="email" class="form-control" id="emailBox" aria-describedby="emailHelp" required>
                <small id="emailText" class="form-text text-warning"></small>
            </div>

            <div class="form-group">
                <label>Password</label>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" id="passwordBox" aria-label="Recipient's username"
                           aria-describedby="button-addon2" required>

                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" id="showPassword">Show</button>
                    </div>
                </div>
                <small id="passwordText" class="form-text text-warning"></small>
            </div>

            <div class="form-group">
                <label>Comfirm your password</label>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" id="confirmBox" aria-label="Recipient's username"
                           aria-describedby="button-addon2" required>
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" id="showConfirmPassword">Show</button>
                    </div>
                </div>
                <small id="confirmText" class="form-text text-warning"></small>
            </div>

        </div>

        <div class="pages" id="second">
            <div class="form-group">
                <label>First name</label>
                <input type="text" class="form-control" id="firstname" required>
            </div>

            <div class="form-group">
                <label>Last name</label>
                <input type="text" class="form-control" id="lastname" required>
            </div>

            <div class="form-group">
                <label>Gender</label>
                <select name="gender" class="form-control" id="gender">
                    <option selected>Choose...</option>
                    <option>Male</option>
                    <option>Female</option>
                    <option>Other</option>
                </select>
                <small id="genderText" class="form-text text-warning"></small>
            </div>

            <div id="app" class="dob form-group">
                <span class="demonstration">Date of birth</span>
                <input id="flatpickr-tryme" class="form-control" data-max-date=today data-date-format="d-m-Y" placeholder="DD-MM-YYYY">
                <small id="dobText" class="form-text text-warning"></small>
            </div>
        </div>

        <button type="submit" class="btn btn-primary" id="submitBtn">Submit</button>
        <button type="button" class="btn btn-primary " id="previous">previous</button>
        &nbsp;
        <button type="button" class="btn btn-primary" id="nextBtn">next</button>
    </form>
</div>
<script async src="./script/flatpickr.min.js" onload="fp_ready()"></script>
<script async>
    function fp_ready() {
        Flatpickr.l10n.firstDayOfWeek = 1;
        document.getElementById("flatpickr-tryme").flatpickr();
    }
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="./script/pagation.js"></script>
</body>
</html>
