<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/26 0026
  Time: 下午 5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order New Card</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="css/orderMenu.css">
</head>
<body class="" style= " background-color: rgba(44, 141, 238, 0.15);">
<div>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 mb-3 bg-white shadow-sm">
        <a href="" class="logo my-0 mr-md-auto font-weight-normal">
            <img src="resources/logo.png" class="logo my-0 mr-md-auto font-weight-normal" alt="" class="logo">
        </a>
    </div>
</div>

<div style="text-align: center;">
    <h1 style="color: orangered;">Get a New Opal Card</h1>
    <br/>
    <h3>Hello <span style="color:rgb(255, 128, 78);">Customer</span>
        <span style="color:rgb(44, 141, 238)">(UserName)</span></h3>
    <br/>
    <a class="btn btn-outline-primary" href="#">Card Type Requirement</a> &nbsp
    <a class="btn btn-outline-primary" href="/orderMenu.jsp">Back</a>
</div>

<div class="container">
    <div id="test" class="test"></div>
    <form class="form" action="orderMenu.jsp" method="post">

        <h5>New Order</h5>

            <div class="form-group">
                <label>Card Type</label>
                <select name="gender" class="form-control" id="gender">
                    <option selected>Choose...</option>
                    <option>Adult</option>
                    <option>Youth</option>
                    <option>Concession</option>
                    <option>Gold Senior</option>
                </select>
                <small id="orderCardType" class="form-text text-warning"></small>
            </div>

            <div class="form-group">
                <label>Delivery Address</label>
                <input type="text" class="form-control" id="deliveryAddress" required>
            </div>

            <div class="form-group">
                <label>Delivery Postcode</label>
                <input type="text" class="form-control" id="deliveryPostcode" required>
            </div>

            <div class="form-group">
                <label>Prefer Delivery Date</label>
                <input type="date" class="form-control" id="deliveryDate" required>
            </div>

        <a class="btn btn-outline-primary" href="/orderMenu.jsp">Cancel</a> &nbsp
        <button type="submit" class="btn btn-primary" id="submitBtn">Submit</button>

    </form>
</div>


<div class="dropdown-divider divider">
</div>

<br>
</body>
</html>
