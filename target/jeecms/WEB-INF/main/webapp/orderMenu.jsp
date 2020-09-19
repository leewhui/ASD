<%--
  Created by IntelliJ IDEA.
  User: Shahao
  Date: 2020/8/24 0024
  Time: 下午 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Menu</title>
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
    <h1 style="color: orangered;">My Order</h1>
    <br/>
    <h3>Hello <span style="color:rgb(255, 128, 78);">Customer</span>
        <span style="color:rgb(44, 141, 238)">(UserName)</span></h3>
    <br/>
    <a class="btn btn-outline-primary" href="/Controller/orderNewCardController">Get a new card</a> &nbsp
    <a class="btn btn-outline-primary" href="#">Card Type Requirement</a> &nbsp
    <a class="btn btn-outline-primary" href="/jsp/main.jsp">Back</a>
</div>

<p>Customers will use this webpage, Staff will be linked to another webpage orderManagement.jsp</p>
<p>The function: </p>
<p>1. View all orders of the current account</p>
<p>2. Search for particular order</p>
<p>3. Get a new opal card </p>

<div align="center">
    <table class="hovertable">
        <tr>
            <th>Order ID</th>
            <th>Order Date</th>
            <th>Card Type</th>
            <th>Delivery Address</th>
            <th>Delivery Postcode</th>
            <th>Status</th>

        </tr>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
            <td>10000001</td>
            <td>23-08-2019</td>
            <td>Adult</td>
            <td>Unit 01, 34-36 ABCD Road, Ultimo</td>
            <td>Delivered</td>

        </tr>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
            <td>10000002</td>
            <td>24-08-2020</td>
            <td>Concession</td>
            <td>Submitted</td>
        </tr>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
            <td>10000003</td>
            <td>24-08-2020</td>
            <td>Adult</td>
            <td>Delivered</td>
        </tr>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
            <td>10000004</td>
            <td>24-08-2020</td>
            <td>Adult</td>
            <td>Delivered</td>
        </tr>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
            <td>10000005</td>
            <td>24-08-2020</td>
            <td>Adult</td>
            <td>Delivered</td>
        </tr>
    </table>
</div>


<div class="dropdown-divider divider">
</div>

<br>
</body>
</html>
