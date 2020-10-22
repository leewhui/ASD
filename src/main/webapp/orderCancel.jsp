<%@ page import="com.app.asd.Model.*" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/19 0019
  Time: 上午 12:20
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
    String username = null;
    String Heading_1 = "Customer User";
    String Heading_2 = "Cancel My Orders";
    User user = (User) session.getAttribute("currentUser");
    String cancelOrderID = null;
    if (user == null)
    {
        System.out.println("logout");
        response.sendRedirect("index.jsp");
    }
    else
    {
        username = user.getUsername();
        if(user.isIs_staff())
        {
            Heading_1 = "Staff User";
            Heading_2 = "Clear All Cancelled Orders";
        }
    }

    ArrayList<Order> OrderList = (ArrayList<Order>) session.getAttribute("OrderList");

    String cancelMessage = (String) session.getAttribute("orderCancelMessage");
    String orderCanMes = "";
    if (cancelMessage != null)
    {
        orderCanMes = cancelMessage;
    }

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

    <h1 style="color: orangered;"><%=Heading_2%></h1>
    <br/>
    <h3>Hello <span style="color:rgb(255, 128, 78);"><%=Heading_1%></span>
        <span style="color:rgb(44, 141, 238)">(<%=username%>)</span></h3>
    <br/>

    <%if(!user.isIs_staff()) {%>
        <h4 style="color:rgb(44, 141, 238)"> <span style="color: orange">Notice:</span> Only the <span style="color: red">newly sumbitted</span> order can be canceled </h4>
        <h4 style="color:rgb(44, 141, 238)"> Those orders which have been viewed and worked by staff can <span style="color: red">NOT</span> be canceled </h4>
        <br/>
    <% }%>

    <%if(user.isIs_staff()) {%>
        <h4 style="color:rgb(44, 141, 238)"> <span style="color: orange">Notice:</span> The function will delete <span style="color: red">ALL</span> of the <span style="color: red">canceled</span> orders</h4>
        <br/>
    <% }%>

</div>

<div style="text-align: center;">
    <% if(!user.isIs_staff()) { %>
        <form action="/Controller/orderCancelController" method="post">
            <label style="font-size: 25px">Cancel one order</label>
            <br/>

            <select name="orderCancel"  id="orderCancel" style="width: 300px ">
                <option selected>Choose...</option>

                <% for (int i = 0; i < OrderList.size() ; i++) {%>
                    <% if (OrderList.get(i).getOrderStatus().equals("Submitted")) {%>
                        <option><%= OrderList.get(i).getOrderID() %> <%= OrderList.get(i).getOrderCardType() %> Opal Card</option>
                    <% } %>
                <% } %>
            </select>
            <br/>
            <br/>

            <input type="text" name="operation" value="C" style="display:none">
            <input type="submit" class="btn btn-outline-primary" value="Cancel the order">
            &nbsp
            <a class="btn btn-outline-primary" href="/Controller/orderMenuController">Back</a>
        </form>
    <% } %>
</div>

<div style="text-align: center;">
    <% if(user.isIs_staff()) { %>
        <form action="/Controller/orderCancelController" method="post">

            <br/> <br/>
            <h2 style="color: cornflowerblue">Do you want to delete <span style="color: red">ALL canceled orders</span> ?</h2>
            <br/>


        <input type="text" name="operation" value="A" style="display:none">
        <input type="submit" class="btn btn-outline-primary" value="Yes">
        &nbsp &nbsp
        <a class="btn btn-outline-primary" href="/Controller/orderMenuController">Back</a>
        </form>
    <% } %>
</div>




<div style="text-align: center">
    <br/>
    <h1 style="color: orangered;"><%=orderCanMes%></h1>

</div>


</body>


</html>
