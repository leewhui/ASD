<%--
  Created by IntelliJ IDEA.
  User: 61405
  Date: 21/09/2020
  Time: 7:07 pm
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        /* Float four columns side by side */
        .column {
            float: left;
            width: 25%;
            padding: 0 10px;
        }

        /* Remove extra left and right margins, due to padding */
        .row {margin: 0 -5px;}

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* Responsive columns */
        @media screen and (max-width: 600px) {
            .column {
                width: 100%;
                display: block;
                margin-bottom: 20px;
            }
        }

        /* Style the counter cards */
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            padding: 16px;
            text-align: center;
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>

<%
    double paymentBalance=(Double)request.getAttribute("balance");
%>

<h2>Opal Cards</h2>
<p>Select cards balance transfer or check the payment invoice.</p>

<% for(int i=0; i<=4; i++){ %>

<div class="row">
    <div class="column">
        <div class="card">
            <h3>Card <%=i%></h3>
            <p>Balance:<%=paymentBalance%></p>
            <form action="../payment.jsp">
                <input type="submit" value="Balance Transfer" class="btn">
            </form>
            <form action="../invoice.jsp">
                <input type="submit" value="Invoice" class="btn">
            </form>
        </div>
    </div>

        <% }%>

    <%--<div class="column">
        <div class="card">
            <h3>Card 2</h3>
            <p>Some text</p>
            <p>Some text</p>
        </div>
    </div>

    <div class="column">
        <div class="card">
            <h3>Card 3</h3>
            <p>Some text</p>
            <p>Some text</p>
        </div>
    </div>

    <div class="column">
        <div class="card">
            <h3>Card 4</h3>
            <p>Some text</p>
            <p>Some text</p>
        </div>
    </div>
</div>--%>

</body>
</html>
