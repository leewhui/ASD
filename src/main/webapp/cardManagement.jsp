<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.app.asd.Model.*"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    User user = (User) session.getAttribute("currentUser");
    String name = user.getUsername();
    String email = user.getEmail();
    String firstname = user.getFirst_name();
    String lastname = user.getLast_name();
    ArrayList<Card> cardResult = (ArrayList<Card>) session.getAttribute("card");
    int cardID = 0;
    String cardNumber = "";
    String cardType = "";
    double cardBalance = 0.00;
    String cardStatus = "";
    String userEmail = "";
    Boolean is_linked = null;
    Boolean is_sold = null;

    for(int i = 0;i < cardResult.size(); i++)
    {
        if(cardResult.get(i).getUserEmail().equals(email))
        {
            cardID = cardResult.get(i).getCardID();
            cardNumber = cardResult.get(i).getOpalCardNumber();
            cardType = cardResult.get(i).getCardType();
            cardBalance = cardResult.get(i).getCardBalance();
            cardStatus = cardResult.get(i).getCardStatus();
            userEmail = cardResult.get(i).getUserEmail();
            is_linked = cardResult.get(i).isIs_linked();
            is_sold = cardResult.get(i).isIs_sold();
        }
        else
        {
            System.out.println("Null");
        }

    }

%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BootStrap</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

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
                <li><a href="#"> Account Management </a> </li>
                <li><a href="#"> Payment </a> </li>
                <li class="active"><a href="#">Card Management</a> </li>
                <li><a href="#">About</a> </li>

            </ul>
            <!--<ul class="nav navbar-nav navbar-right">
                <form action = "logout">
                <li align="right"><a href="#">Log out</a></li>
            </ul>-->
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

            <div class="panel-body" id="resultTable">

                <div class="card">

                    <table class="table table-hover table-bordered table-responsive table-curved" style="width: 55%; height: auto;" align="center">
                        <tbody>


                        <tr>
                            <td align="left">Card ID:</td>
                            <td><%=cardID%></td>
                        </tr>
                        <tr>
                            <td align="left">Card Number:</td>
                            <td><%=cardNumber%></td>
                        </tr>
                        <tr>
                            <td align="left">Card Type:</td>
                            <td><%=cardType%></td>
                        </tr>
                        <tr>
                            <td align="left">Card Balance:</td>
                            <td><%=cardBalance%></td>
                        </tr>
                        <tr>
                            <td align="left">Card Status:</td>
                            <td><%=cardStatus%></td>
                        </tr>
                        </tbody>
                    </table>
                </div>


                <!----------------------Activete & Confirmation----------------------------------------------------------------------------------------------------------------------------------------------------------->
                <div align="center" style="padding: 30px;">
                    <!button type="button" class="btn btn-primary">
                    <button class="btn btn-primary btn-md" data-toggle="modal" data-target="#activeModal">
                        Activate
                    </button>
                    <div class="modal fade" id="activeModal" tabindex="-1" role="dialog" aria-labelledby="activateLabel" aria-hidden="true">

                        <div class="modal-dialog">

                            <div class="modal-content">

                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                    <h4 class="modal-title" id="activateLabel">
                                        <p> Activate - Review and confirm </p>
                                    </h4>
                                </div>

                                <div class="modal-body">
                                    <div>
                                        <table class="table table-hover table-bordered table-responsive" style="width: 55%; height: auto;" align="center">
                                            <tbody>

                                            <tr>
                                                <td align="left">Card ID:</td>
                                                <td><%=cardID%></td>
                                            </tr>
                                            <tr>
                                                <td align="left">Card Number:</td>
                                                <td><%=cardNumber%></td>
                                            </tr>
                                            <tr>
                                                <td align="left">Card Type:</td>
                                                <td><%=cardType%></td>
                                            </tr>
                                            <tr>
                                                <td align="left">Card Balance:</td>
                                                <td><%=cardBalance%></td>
                                            </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <form action="cardManagementController" method ="post" >
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">
                                        Cancel
                                    </button>
                                    <input type="hidden" value="Activated" name="cardStatus">
                                    <input type="hidden" value=<%=cardID%> name="cardID">
                                    <input type="hidden" value=<%=cardNumber%> name="opalCardNumber">
                                    <input type="hidden" value=<%=cardType%> name="cardType">
                                    <input type="hidden" value=<%=cardBalance%> name="cardBalance">
                                    <input type="hidden" value=<%=userEmail%> name="userEmail">
                                    <input type="hidden" value=<%=is_linked%> name="is_linked">
                                    <input type="hidden" value=<%=is_sold%> name="is_sold">

                                    <input type="submit" value ="Apply"class="btn btn-primary">

                                </div>
                                </form>

                            </div>
                        </div>
                    </div>


                    <!----------------------Freeze Button & confirmation---------------------------------------------------------------------->

                    <button class="btn btn-default btn-md" data-toggle="modal" data-target="#freezeModal">
                        Freeze
                    </button>
                    <div class="modal fade" id="freezeModal" tabindex="-1" role="dialog" aria-labelledby="freezeLabel" aria-hidden="true">

                        <div class="modal-dialog">

                            <div class="modal-content">

                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                    <h4 class="modal-title" id="freezeLabel">
                                        <p>Freeze - Review and confirm</p>
                                    </h4>
                                </div>

                                <div class="modal-body">
                                    <div>
                                        <table class="table table-hover table-bordered table-responsive" style="width: 55%; height: auto;" align="center">
                                            <tbody>
                                            <tr>
                                                <td align="left">Card ID:</td>
                                                <td><%=cardID%></td>
                                            </tr>
                                            <tr>
                                                <td align="left">Card Number:</td>
                                                <td><%=cardNumber%></td>
                                            </tr>
                                            <tr>
                                                <td align="left">Card Type:</td>
                                                <td><%=cardType%></td>
                                            </tr>
                                            <tr>
                                                <td align="left">Card Balance:</td>
                                                <td><%=cardBalance%></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <form action="cardManagementController" method ="post" >
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">
                                            Cancel
                                        </button>
                                        <input type="hidden" value="Frozen" name="cardStatus">
                                        <input type="hidden" value=<%=cardID%> name="cardID">
                                        <input type="hidden" value=<%=cardNumber%> name="opalCardNumber">
                                        <input type="hidden" value=<%=cardType%> name="cardType">
                                        <input type="hidden" value=<%=cardBalance%> name="cardBalance">
                                        <input type="hidden" value=<%=userEmail%> name="userEmail">
                                        <input type="hidden" value=<%=is_linked%> name="is_linked">
                                        <input type="hidden" value=<%=is_sold%> name="is_sold">
                                        <input type="submit" value ="Apply"class="btn btn-primary">

                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<!----------------------pagination------------------------------------------------------------------------------------->

<!--<div align="center">
    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item disabled"> <a class="page-link" href="#" tabindex="-1" aria-disabled="true">&laquo;</a> </li>
            <li class="page-item active" aria-current="page"> <a class="page-link" href="#">1 <span class="sr-only">(current)</span></a> </li>
            <li class="page-item"> <a class="page-link" href="#">2</a> </li>
            <li class="page-item"> <a class="page-link" href="#">3</a> </li>
            <li class="page-item">
                <a class="page-link" href="#">&raquo;</a>
            </li>
        </ul>
    </nav>
</div>-->




</body>

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>