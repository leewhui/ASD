<%--
  Created by IntelliJ IDEA.
  User: 61405
  Date: 22/09/2020
  Time: 11:17 am
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.app.asd.Model.Card"%>
<%@ page import="com.app.asd.Model.Payment" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./css/payment.css">

    <!--  JavaScript -->
    <script src="script/payment.js"></script>

    <style>
        input[type=number]{
            font-size: 16px;
            width: 100%;
            height: 50px;
            padding-right: 40px;
            padding-left: 16px;
            color: rgba(46, 46, 46, .8);
            border: 1px solid rgb(225, 225, 225);
            border-radius: 4px;
            outline: none;
        }

        input[type=month]{
            font-size: 16px;
            width: 100%;
            height: 50px;
            padding-right: 40px;
            padding-left: 16px;
            color: rgba(46, 46, 46, .8);
            border: 1px solid rgb(225, 225, 225);
            border-radius: 4px;
            outline: none;
        }
    </style>



    <title>Opal Card</title>
</head>


<body>

<%
    // Comment: this page processing payment of top up while you type everything detail of payment credit card, or you can save this payment card for next payment use.

    Card card = (Card)session.getAttribute("chosenCard");
    int cardID = card.getCardID();

    Payment paymentCard = (Payment) session.getAttribute("paymentCard");

%>

<form class="form" role="form" action="processingServlet" method="post">

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
                    <input id="card" type="radio" checked>
                    Pay amount with Card
                </div>
            </label>

        </div>

        <div class="input-fields">

            <div class="column-1">
                <label for="cardholder">Top up Amount</label>
                <input type="number" name="payment" placeholder="Type amount to top up(1-200)" min="0" max="200" />
                <br><br>
            </div>

        </div>

        <div class="input-fields">
            <%
                if (paymentCard ==null){
            %>
            <div class="column-1">
                <label for="cardholder">Name</label>
                <input type="text" id="cardholder" name="cardName"  required/>

                <div class="small-inputs">
                    <div>
                        <label for="date">Valid date</label>
                        <input type="month" id="date" name="validDate" required/>
                    </div>

                    <div>
                        <label for="verification">CVV / CVC *</label>
                        <input type="text" id="verification" name="CVV" maxlength="3" pattern="\d{3}" required/>
                    </div>
                </div>

                <br><br>
                <input type="checkbox" name="autoSaved"> Save your Card Detail for future use.
                <br><br>

            </div>
            <div class="column-2">
                <label for="cardnumber">Card Number</label>
                <input type="text" id="creditCardNumber" name="creditCardNumber" maxlength="8" pattern="\d{8}" required/>

                <span class="info">* CVV or CVC is the card security code, unique three digits number on the back of your card separate from its number.</span>

            </div>

            <%
            }else{
                String cardName = paymentCard.getCardName();
                String creditCardNumber = paymentCard.getCreditCardNumber();
                String validDate = paymentCard.getValidDate();
                String CVV = paymentCard.getCVV();
            %>

            <div class="column-1">
                <div class="col-md-4 col-lg-4 col-sm-4">
                    <label>
                        <input type="radio" name="product" class="card-input-element" checked/>

                        <div class="panel panel-default card-input">
                            <div class="panel-heading">Previous Saved Credit Card
                                <button type="submit" name="delete" value="delete"/> Delete </button>
                            </div>
                            <div class="panel-body">
                                <p>Name:<%=cardName%></p>
                                <p>Card Number:<%=creditCardNumber%></p>
                                <p>Valid Date: <%=validDate%></p>

                            </div>
                        </div>
                    </label>
                </div>
            </div>

            <div class="column-2">
                <br><br>
                <label for="cardnumber">CVV</label>
                <input type="text" name="CVV2" id="cardnumber" value="<%=CVV%>" maxlength="3" pattern="\d{3}" />

                <span class="info">* CVV or CVC is the card security code, unique three digits number on the back of your card separate from its number.</span>
            </div>

            <%
                }
            %>
        </div>

    </div>



    <div class="panel-footer">
        <a href="paymentServlet" class="btn back-btn">Cancel</a>
        <button type="submit" name="confirm" value="confirm" class="btn next-btn">Confirm</button>
    </div>
</div>

</form>

</body>
</html>
