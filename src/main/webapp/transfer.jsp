<%@page import="com.app.asd.Model.*"%>
<%@page import="com.app.asd.Model.User"%>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/cardStatus.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!--  JavaScript -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="script/jquery.js"></script>
    <script src="script/all.min.js"></script>
    <style>

    </style>

    <title>Opal Card</title>
</head>

<body>

<%
    // Comment: this page select transfer cards from Saved Card array of this user, and processing to next servlet

    User user = (User) session.getAttribute("currentUser");
    Card[] cards = (Card[]) session.getAttribute("cards");
    String userEmail = user.getEmail();
    boolean cardExist = false;
    if (cards.length != 0){
        cardExist = true;
    }
%>

<div class="container-fluid">
    <h1 class="w3-wide" align ="center" style=font-size:60px>
        Select Card to transfer<br/> Hi,User <%=userEmail%>
    </h1>

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner row w-100 mx-auto">

            <%
                if(cardExist == true){
                    for(int i=0; i< cards.length; i++) {
                        int cardID = cards[i].getCardID();
                        String opalCardNumber = cards[i].getOpalCardNumber();
                        String cardType = cards[i].getCardType();
                        double cardBalance = cards[i].getCardBalance();
                        String cardStatus = cards[i].getCardStatus();
            %>
            <% if(i == 0){ %>
            <div class="carousel-item col-md-3 active">
                <% } else { %>
                <div class="carousel-item col-md-3 ">
                    <% } %>

                    <div class="card">
                        <% if(cardType.equals("Adult")){ %>
                        <img class="card-img-top img-fluid" src="resources/adultCard.jpg" alt="card-img">
                        <% } else if(cardType.equals("Child")){ %>
                        <img class="card-img-top img-fluid" src="resources/childCard.jpg" alt="card-img">
                        <% } else if(cardType.equals("Concession")){ %>
                        <img class="card-img-top img-fluid" src="resources/concessionCard.jpg" alt="card-img">
                        <% } else if(cardType.equals("Senior")){ %>
                        <img class="card-img-top img-fluid" src="resources/seniorCard.jpg" alt="card-img">
                        <% } %>
                        <div class="details">
                            <div class="textContent">
                                <h3><%=cardType%></h3>
                                <div class="price">$<%=cardBalance%></div>
                            </div>

                            <form class="form" role="form" action="transferNextCard" method="post">
                                <button type="submit" name="transfer" value="<%=i%>" class="btn"> Transfer </button>
                            </form>
                        </div>
                        <div class="description">
                            <div class="icon"><i class="fas fa-info-circle"></i></div>
                            <div class="contents">
                                <h2>Card Details</h2>
                                <p>CardID: <%=cardID%></p>
                                <p>CardNumber: <%=opalCardNumber%></p>
                                <p>CardStatus: <%=cardStatus%></p>
                            </div>
                        </div>
                    </div>
                </div>

                <% }%>

                <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
                <a href="main.jsp" class="btn back-btn">Back to main page</a>
            </div>
        </div>

        <% } else{%>

        <h1 class="w3-wide" align ="center" style=font-size:60px>
            This User doesn't link the card yet! Please link opal card first!
        </h1>
        <a href="main.jsp" class="btn back-btn">Back</a>
    </div>

    <%}%>

</div>



</body>
</html>