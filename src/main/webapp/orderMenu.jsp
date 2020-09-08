<%--
  Created by IntelliJ IDEA.
  User: Shahao
  Date: 2020/8/24 0024
  Time: 下午 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.app.asd.model.*"%>
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

<%
    ArrayList<Order> itemList = (ArrayList<Order>) session.getAttribute("itemList");

%>



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
    <h3>Hello <span style="color:rgb(255, 128, 78);">Customer Shahao</span>
        <span style="color:rgb(44, 141, 238)">13066206</span></h3>
    <br/>
    <a class="btn btn-outline-primary" href="/Controller/orderNewCardController">Get a new card</a> &nbsp
    <a class="btn btn-outline-primary" href="#">Card Type Requirement</a> &nbsp
    <a class="btn btn-outline-primary" href="/jsp/main.jsp">Back</a>
</div>

<br/>

<div class="form-group" style="text-align: center;">
    <span>Search by</span>
    <input type="text" id="ItemSearchInput" onkeyup="SearchTable()" placeholder="Order ID or Date">
</div>

<script>
    function SearchTable()
    {
        var input, filter, table, tr, itemName, categoryName, i, nameValue, categoryValue;
        input = document.getElementById("ItemSearchInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("itemTable");
        tr = table.getElementsByTagName("tr");

        for (i = 0; i < tr.length; i++) {
            itemName = tr[i].getElementsByTagName("td")[0];
            categoryName = tr[i].getElementsByTagName("td")[1];
            if (itemName) {
                nameValue = itemName.textContent || itemName.innerText;
                categoryValue = categoryName.textContent || categoryName.innerText;

                if (nameValue.toUpperCase().indexOf(filter) > -1 || categoryValue.toUpperCase().indexOf(filter) > -1) {
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
    <table class="hovertable" id="itemTable">
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
            <td>Unit 01, 34-36 ABCD Road, Ultimo, NSW</td>
            <td>2007</td>
            <td>Delivered</td>

        </tr>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
            <td>10000002</td>
            <td>24-08-2020</td>
            <td>Concession</td>
            <td>Unit 02, 34-36 ABCD Road, Ultimo, NSW</td>
            <td>2007</td>
            <td>Submitted</td>
        </tr>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
            <td>10000003</td>
            <td>29-08-2020</td>
            <td>Adult</td>
            <td>Unit 11, 88 EFGH Road, ZXY, VIC</td>
            <td>2007</td>
            <td>Delivered</td>
        </tr>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
            <td>10000004</td>
            <td>01-09-2020</td>
            <td>Adult</td>
            <td>Unit 16, 18 Center Road, Ultimo, NSW</td>
            <td>2007</td>
            <td>Delivered</td>
        </tr>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
            <td>10000005</td>
            <td>02-09-2020</td>
            <td>Adult</td>
            <td>Unit 05, 18 QWER Road, Ultimo, NSW</td>
            <td>2007</td>
            <td>Delivered</td>
        </tr>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
            <td>10000006</td>
            <td>05-09-2020</td>
            <td>Adult</td>
            <td>Unit 09, 105 QWER Road, Ultimo, NSW</td>
            <td>2007</td>
            <td>Delivered</td>
        </tr>


    </table>
</div>


<div class="dropdown-divider divider">
</div>

<br>
</body>
</html>
