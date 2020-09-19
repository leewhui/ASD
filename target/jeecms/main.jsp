<%--
  Created by IntelliJ IDEA.
  User: wenhuili
  Date: 18/8/20
  Time: 1:41 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css">
</head>

<body>
    <div>
        <div class="d-flex flex-column flex-md-row align-items-center p-3 mb-3 bg-white shadow-sm">
            <a href="" class="logo my-0 mr-md-auto font-weight-normal">
                <img src="resources/logo.png" class="logo my-0 mr-md-auto font-weight-normal" alt="" class="logo">
            </a>
            <span>Welcome <span style="color: orangered;">XXX</span></span>
        </div>

        <br>
        <div class="container">
            <ul class="nav-card clearfix" id="service">
                <h3>Services</h3>
                <li class="card" style="width: 18rem;">
                    <img src="resources/top%20up.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Top up</h5>
                        <p class="card-text">Plan ahead or top up online</p>
                        <a href="../../java/com.app.asd/Controller/paymentController" class="btn btn-primary">Go for it</a>
                    </div>
                </li>

                <li class="card" style="width: 18rem;">
                    <img src="resources/buy.png" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Order New Card</h5>
                        <p class="card-text">Get a new opal card</p>
                        <a href="Controller/orderMenuController" class="btn btn-primary">Go for it</a>
                    </div>
                </li>

                 <li class="card" style="width: 18rem;">
                    <img src="resources/paper.jpg" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Admin System</h5>
                        <p class="card-text">For system admin to manage user</p>
                        <a href="adminHome.jsp" class="btn btn-primary">Go for it</a>
                    </div>
                </li>

                <form class="form" role="form" action="paymentServlet" method="post">
                <li class="card" style="width: 18rem;">
                    <img src="resources/transfer.jpg" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Transfer</h5>
                        <p class="card-text">Transfer between two accounts</p>
                        <input type="text" class="form-control" id="payment-ID" placeholder="Enter paymentID ..." name="paymentID" maxlength="10">
                        <button id="submit_btn" type="submit" class="btn btn-primary">Go for it</button>
                    </div>
                </li>
                </form>

                <li class="card" style="width: 18rem;">
                    <img src="resources/info.jpg" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">User information</h5>
                        <p class="card-text">View Your Profile</p>
                        <a href="userInfo.jsp" class="btn btn-primary">Go for it</a>

                    </div>
                </li>

                <li class="card" style="width: 18rem;">
                    <img src="resources/management.jpg" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Manage card</h5>
                        <p class="card-text">Manage your opal card online</p>
                        <a href="cardManagement.jsp" class="btn btn-primary">Go for it</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</body>

</html>
