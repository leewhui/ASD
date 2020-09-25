<%--
  Created by IntelliJ IDEA.
  User: Shahao
  Date: 2020/8/24 0024
  Time: 下午 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.app.asd.Model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

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
<body class="" style= " background-color: rgba(254,249,214,1);">

<%
    String username = null;
    String Heading_1 = "Customer User";
    String Heading_2 = "My Orders";
    User user = (User) session.getAttribute("currentUser");

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
            Heading_2 = "All Orders";
        }
    }

    //List OrderList = (List) session.getAttribute("OrderList");
    ArrayList<Order> OrderList = (ArrayList<Order>) session.getAttribute("OrderList");
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
    <h1 style="color: orangered;"><%=Heading_2%></h1>
    <br/>
    <h3>Hello <span style="color:rgb(255, 128, 78);"><%=Heading_1%></span>
        <span style="color:rgb(44, 141, 238)">(<%=username%>)</span></h3>
    <br/>
    <% if(user.isIs_staff()) {%>
        <a class="btn btn-outline-primary" href="#">Clear All Order (R2)</a> &nbsp
        <a class="btn btn-outline-primary" href="../main.jsp">Back</a>
    <% } %>
    <% if(!user.isIs_staff()) { %>
        <a class="btn btn-outline-primary" href="../orderNewCard.jsp">Get a new card</a> &nbsp
        <a class="btn btn-outline-primary" href="#">Card Type Requirement (R2)</a> &nbsp
        <a class="btn btn-outline-primary" href="../main.jsp">Back</a>
    <% } %>
</div>

<br />

<div class="form-group" style="text-align: center;">
    <span>Search by</span>
    <input type="text" id="orderSearchInput" onkeyup="SearchTable()" placeholder="Order ID or Date">
</div>



<script>
    function SearchTable()
    {
        var input, filter, table, tr, orderID, orderDate, i, idValue, dateValue;
        input = document.getElementById("orderSearchInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("orderTable");
        tr = table.getElementsByTagName("tr");

        for (i = 0; i < tr.length; i++) {
            orderID = tr[i].getElementsByTagName("td")[0];
            orderDate = tr[i].getElementsByTagName("td")[1];
            if (orderID) {
                idValue = orderID.textContent || orderID.innerText;
                dateValue = orderDate.textContent || orderDate.innerText;

                if (idValue.toUpperCase().indexOf(filter) > -1 || dateValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                }
                else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>

<div align="center">
    <table class="hovertable" id="orderTable">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Card Type</th>
                <th>Delivery Address</th>
                <th>Delivery Postcode</th>
                <th>Status</th>
                <% if (user.isIs_staff()) {%>
                    <th>Edit</th>
                <% } %>

            </tr>
        </thead>

        <tbody>
            <% for (int i = 0; i < OrderList.size() ; i++) {%>
                <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
                    <td><%= OrderList.get(i).getOrderID() %></td>
                    <td><%= OrderList.get(i).getOrderDate() %></td>
                    <td><%= OrderList.get(i).getOrderCardType() %></td>
                    <td><%= OrderList.get(i).getDeliveryAddress() %></td>
                    <td><%= OrderList.get(i).getDeliveryPostcode() %></td>
                    <td><%= OrderList.get(i).getOrderStatus() %></td>
                    <% if (user.isIs_staff()) {%>
                        <td>
                        <form method="post" action="/Controller/orderUpdateController" style="text-align:center;">
                            <input type="text" name="operation" value="R" style="display:none">
                            <input type="text" name="orderID" value="<%= OrderList.get(i).getOrderID()%>" style="display:none">
                            <input type="submit" class="btn btn-outline-primary" value="Edit">
                        </form>
                        </td>
                    <% } %>

                </tr>
            <% } %>



        </tbody>
    </table>
</div>


<div class="dropdown-divider divider">
</div>

<br>
</body>
</html>
