<%@ page import="com.app.asd.Model.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23 0023
  Time: 下午 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Menu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/orderMenu.css">
</head>

<body style= " background-color: rgba(44, 141, 238, 0.15);">
<%
    Order order = (Order) session.getAttribute("currentOrder");

    String heading_1 = "Order ID " + order.getOrderID();

    String orderStaMes = (String) session.getAttribute("orderStatusMessage");

    //List OrderList = (List) session.getAttribute("OrderList");
    // ArrayList<Order> OrderList = (ArrayList<Order>) session.getAttribute("OrderList");
    // ArrayList<Order> OrderList1 = (ArrayList<Order>) session.getAttribute("OrderList1");
%>

<div>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 mb-3 bg-white shadow-sm">
        <a href="" class="logo my-0 mr-md-auto font-weight-normal">
            <img src="/resources/logo.png" class="logo my-0 mr-md-auto font-weight-normal" alt="" class="logo">
        </a>
    </div>
</div>

<div style="text-align: right">
    <a class="btn btn-outline-primary" href="../logoutServlet">Log Out</a>
    &emsp;
</div>

<div style="text-align: center;">
    <h1 style="color: orangered;"><%=heading_1%></h1>
    <br/>
    <h2 style="color: orangered;">Order Status: <%=order.getOrderStatus()%></h2>

    <br/>
    <h1 style="color: orangered;"><%=orderStaMes%></h1>
</div>

    <div style="text-align: center">

        <form action="/Controller/orderUpdateController" method="post">

            <br/>

            <select name="orderStatus"  id="orderStatus" style="width: 300px ">
                <option selected>Choose...</option>
                <option>Submitted</option>
                <option>Delivered</option>
                <option>Done</option>
            </select>

            <br/>

        <div>
            <br/>
            <input type="text" name="operation" value="U" style="display:none">

            <input type="submit" class="btn btn-outline-primary" value="Change Order Status">
            &nbsp
            <a class="btn btn-outline-primary" href="/Controller/orderMenuController">Back</a>
        </div>

        <br/>
        <br/>
        <h3 style="color:rgb(44, 141, 238)"> Further Management Function will be added in Release 2 </h3>

        </form>
    </div>







</body>


</html>
