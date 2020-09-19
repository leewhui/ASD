<!DOCTYPE html>
<html>
<head>
    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            max-width: 300px;
            margin: auto;
            text-align: center;
            font-family: arial;
        }

        .price {
            color: grey;
            font-size: 22px;
        }

        .card button {
            border: none;
            outline: 0;
            padding: 12px;
            color: white;
            background-color: #000;
            text-align: center;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
        }

        .card button:hover {
            opacity: 0.7;
        }

        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 12px;
            margin: 10px 0;
            border: none;
            width: 100%;
            border-radius: 3px;
            cursor: pointer;
            font-size: 17px;
        }

    </style>
</head>
<body>

<h2 style="text-align:center">Product Card</h2>

<%
    double paymentBalance=(Double)request.getAttribute("balance");
%>

<div class="card">
    <img src="./card.png" alt="Denim Jeans" style="width:100%">
    <h1>Leo1</h1>
    <p class="price"><%=paymentBalance%></p>
    <form action="payment.jsp">
        <input type="submit" value="Card AutoCharge" class="btn">
    </form>
    <form action="payment.jsp">
        <input type="submit" value="Transfer" class="btn">
    </form>
</div>

</body>
</html>
