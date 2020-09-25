<%--
  Created by IntelliJ IDEA.
  User: 61405
  Date: 21/09/2020
  Time: 10:36 pm
  To change this template use File | Settings | File Templates.
--%>

<%@page import="com.app.asd.module.*"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>A simple, clean, and responsive HTML invoice template</title>

    <style>
        .invoice-box {
            max-width: 800px;
            margin: auto;
            padding: 30px;
            border: 1px solid #eee;
            box-shadow: 0 0 10px rgba(0, 0, 0, .15);
            font-size: 16px;
            line-height: 24px;
            font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
            color: #555;
        }

        .invoice-box table {
            width: 100%;
            line-height: inherit;
            text-align: left;
        }

        .invoice-box table td {
            padding: 5px;
            vertical-align: top;
        }

        .invoice-box table tr td:nth-child(2) {
            text-align: right;
        }

        .invoice-box table tr.top table td {
            padding-bottom: 20px;
        }

        .invoice-box table tr.top table td.title {
            font-size: 45px;
            line-height: 45px;
            color: #333;
        }

        .invoice-box table tr.information table td {
            padding-bottom: 40px;
        }

        .invoice-box table tr.heading td {
            background: #eee;
            border-bottom: 1px solid #ddd;
            font-weight: bold;
        }

        .invoice-box table tr.details td {
            padding-bottom: 20px;
        }

        .invoice-box table tr.item td{
            border-bottom: 1px solid #eee;
        }

        .invoice-box table tr.item.last td {
            border-bottom: none;
        }

        .invoice-box table tr.total td:nth-child(2) {
            border-top: 2px solid #eee;
            font-weight: bold;
        }

        @media only screen and (max-width: 600px) {
            .invoice-box table tr.top table td {
                width: 100%;
                display: block;
                text-align: center;
            }

            .invoice-box table tr.information table td {
                width: 100%;
                display: block;
                text-align: center;
            }
        }

        /** RTL **/
        .rtl {
            direction: rtl;
            font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
        }

        .rtl table {
            text-align: right;
        }

        .rtl table tr td:nth-child(2) {
            text-align: left;
        }
    </style>
</head>

<%
    Payment invoice = (Payment)session.getAttribute("invoice");
    int paymentID = invoice.getPaymentID();
    int creditCardNumber = invoice.getCreditCardNumber();
    String paymentType = invoice.getPaymentType();
    double paymentBalance = invoice.getPaymentBalance();
    String paymentStatus = invoice.getPaymentStatus();
    String paymentDate = invoice.getPaymentDate();
    String gender = invoice.getGender();
    String billingAddress = invoice.getBillingAddress();
    int userID = invoice.getUserID();
%>

<body>
<div class="invoice-box">
    <table cellpadding="0" cellspacing="0">
        <tr class="top">
            <td colspan="2">
                <table>
                    <tr>
                        <td class="title">
                            <img src="./resources/logo.png" style="width:100%; max-width:300px;">
                        </td>

                        <td>
                            Invoice #: <%=paymentID%><br>
                            Created: <%=paymentDate%><br>
                            Due: 31-21-2020
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr class="information">
            <td colspan="2">
                <table>
                    <tr>
                        <td>
                            Sparksuite, Inc.<br>
                            12345 Sunny Road<br>
                            Sunnyville, CA 12345
                        </td>

                        <td>
                            Acme Corp.<br>
                            John Doe<br>
                            john@example.com
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr class="heading">
            <td>
                Payment Method
            </td>

            <td>
                PaymentID
            </td>
        </tr>

        <tr class="details">
            <td>
                <%=paymentType%>
            </td>

            <td>
                <%=paymentID%>
            </td>
        </tr>

        <tr class="heading">
            <td>
                Opal Card
            </td>

            <td>
                Top up Amount
            </td>
        </tr>

        <tr class="item">
            <td>
                Adult Card: <%=creditCardNumber%>
            </td>

            <td>
                <%=paymentBalance%>
            </td>
        </tr>

        <tr class="item">
            <td>
                GST (10% included)
            </td>

            <td>
                $2
            </td>
        </tr>

        <tr class="item last">
            <td>
                Card Access Fee
            </td>

            <td>
                $1
            </td>
        </tr>

        <tr class="total">
            <td></td>

            <td>
                Total: $23
            </td>
        </tr>
    </table>
</div>
</body>
</html>
