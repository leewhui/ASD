<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.app.asd.Model.*"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    User user = (User) session.getAttribute("currentUser"); //Get user data from session
    String email = user.getEmail(); //get user email to identify card
    ArrayList<Card> cardResult = (ArrayList<Card>) session.getAttribute("card");//get card data
    ArrayList<Card> cardTableResult = new ArrayList<Card>();//set arraylist to store card result.

    for(int i = 0;i < cardResult.size(); i++)
    {
        try
        {
            if(cardResult.get(i).getUserEmail().equals(email))
            {
                cardTableResult.add(cardResult.get(i));
            }
        }
        catch (Exception e)
        {

        }

    }

%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BootStrap</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/cardManagement.css">


</head>
<body>



<!----------------------Navbar----------------------------------------------------------------------------------------------------------------------------------------------------------->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">Opera Card</a>
        </div>

        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="main.jsp">HomePage</a></li>
                <li class="active"><a href="#">Card Management</a> </li>
            </ul>
        </div>

    </div>
</nav>


<!----------------------information panel----------------------------------------------------------------------------------------------------------------------------------------------------------->
<div class="container">
    <div class="starter" >
        <div class="Head">
            <h2>Card Management</h2>
        </div>

        <div class="panel panel-primary">
            <div class="panel-heading">
                Card Status
            </div>

               <!----------------------------------Card Table ------------------------>
                <div class="card" style="padding: 50px;">
                    <table class="table table-hover table-striped table-responsive" style="width:75%; height: auto;" align="center">
                        <thead>
                        <tr>
                            <th style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px">Card ID</th>
                            <th style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px">Card Number</th>
                            <th style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px">Card Type</th>
                            <th style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px">Card Balance</th>
                            <th style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px">Card Status</th>
                            <th style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px">Activate</th>
                            <th style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px">Freeze</th>
                        </tr>
                        </thead>

                        <tbody>
                        <% for (int i = 0; i < cardTableResult.size() ; i++) {%>
                        <tr>
                            <td style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px"><%= cardTableResult.get(i).getCardID() %></td>
                            <td style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px"><%= cardTableResult.get(i).getOpalCardNumber() %></td>
                            <td style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px"><%= cardTableResult.get(i).getCardType() %></td>
                            <td style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px"><%= cardTableResult.get(i).getCardBalance() %></td>
                            <td style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px"><%= cardTableResult.get(i).getCardStatus() %></td>
                            <td style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px">
                             <form method="post" action="cardManagementController" style="text-align:center;">
                                <input type="hidden" value="Activated" name="cardStatus">
                                <input type="hidden" value=<%=cardTableResult.get(i).getCardID()%> name="cardID">
                                <input type="hidden" value=<%=cardTableResult.get(i).getOpalCardNumber()%> name="opalCardNumber">
                                <input type="hidden" value=<%=cardTableResult.get(i).getCardType()%> name="cardType">
                                <input type="hidden" value=<%=cardTableResult.get(i).getCardBalance()%> name="cardBalance">
                                <input type="hidden" value=<%=cardTableResult.get(i).getUserEmail()%> name="userEmail">
                                <input type="hidden" value=<%=cardTableResult.get(i).isIs_linked()%> name="is_linked">
                                <input type="hidden" value=<%=cardTableResult.get(i).isIs_sold()%> name="is_sold">
                                <input type="submit" align="center" value ="Activate"class="btn btn-primary" data-toggle="popover" data-trigger= 'hover' title="Activate Confirmation" data-content="Please check your card information">
                             </form>
                            </td>
                            <td style="vertical-align: middle !important;text-align: center; border-left: 0px; border-right: 0px">
                                <form method="post" action="cardManagementController" style="text-align:center;">
                                    <input type="hidden" value="Frozen" name="cardStatus">
                                    <input type="hidden" value=<%=cardTableResult.get(i).getCardID()%> name="cardID">
                                    <input type="hidden" value=<%=cardTableResult.get(i).getOpalCardNumber()%> name="opalCardNumber">
                                    <input type="hidden" value=<%=cardTableResult.get(i).getCardType()%> name="cardType">
                                    <input type="hidden" value=<%=cardTableResult.get(i).getCardBalance()%> name="cardBalance">
                                    <input type="hidden" value=<%=cardTableResult.get(i).getUserEmail()%> name="userEmail">
                                    <input type="hidden" value=<%=cardTableResult.get(i).isIs_linked()%> name="is_linked">
                                    <input type="hidden" value=<%=cardTableResult.get(i).isIs_sold()%> name="is_sold">
                                    <input type="submit" align="center" value ="Freeze"class="btn btn-default" data-toggle="popover" data-trigger= 'hover' title="Freeze Confirmation" data-content="Please check your card information">
                                </form>
                            </td>
                            <% } %>
                        </tr>
                        </tbody>
                    </table>
                </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        $("[data-toggle='popover']").popover();
    });
</script>

</body>

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>
