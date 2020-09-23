<%--
  Created by IntelliJ IDEA.
  User: 61405
  Date: 22/09/2020
  Time: 11:17 am
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.app.asd.module.Card"%>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./css/paymentVer2.css">

    <!--  JavaScript -->
    <script src="./script/paymentVer2.js"></script>


    <title>Opal Card</title>
</head>


<body>

<%
    Card card = (Card)session.getAttribute("chosenCard");
    int cardID = card.getCardID();
    session.setAttribute("cardID",cardID);
%>

<div class="checkout-panel">
    <div class="panel-body">
        <h2 class="title">Top up here!</h2>

        <div class="progress-bar">
            <div class="step active"></div>
            <div class="step active"></div>
            <div class="step"></div>
            <div class="step"></div>
        </div>

        <div class="payment-method">
            <label for="card" class="method card">
                <div class="card-logos">
                    <img src="https://designmodo.com/demo/checkout-panel/img/visa_logo.png"/>
                    <img src="https://designmodo.com/demo/checkout-panel/img/mastercard_logo.png"/>
                </div>

                <div class="radio-input">
                    <input id="card" type="radio" name="payment" value="20">
                    Pay AU$20 with credit card
                </div>
            </label>

            <label for="paypal" class="method paypal">
                <img src="https://designmodo.com/demo/checkout-panel/img/paypal_logo.png"/>
                <div class="radio-input">
                    <input id="paypal" type="radio" name="payment" value="20">
                    Pay AU$20 with PayPal
                </div>
            </label>
        </div>

        <div class="input-fields">
            <div class="column-1">
                <label for="cardholder">Name</label>
                <input type="text" id="cardholder" />

                <div class="small-inputs">
                    <div>
                        <label for="date">Valid date</label>
                        <input type="text" id="date"/>
                    </div>

                    <div>
                        <label for="verification">CVV / CVC *</label>
                        <input type="password" id="verification"/>
                    </div>
                </div>

            </div>
            <div class="column-2">
                <label for="cardnumber">Card Number</label>
                <input type="password" id="cardnumber"/>

                <span class="info">* CVV or CVC is the card security code, unique three digits number on the back of your card separate from its number.</span>
            </div>
        </div>
    </div>

    <div class="panel-footer">
        <form action="cardStatus.jsp">
        <button type="submit" name="back" value="back"  class="btn back-btn">Back</button>
        </form>
        <form class="form" role="form" action="processingServlet" method="post">
        <button type="submit" name="confirm" value="confirm" class="btn next-btn">Confirm</button>
        </form>
    </div>
</div>


</body>
</html>
