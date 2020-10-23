package com.app.asd.Controller;

import com.app.asd.Model.Card;
import com.app.asd.Model.User;
import com.app.asd.Utils.DAO.CardDAO;
import com.app.asd.Utils.DAO.MongoDB;
import com.app.asd.Utils.DAO.PaymentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class paymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Comment: this servlet retrieve selected card,then save to next page (transfer or top up).It also checked value of payment card, it has different page view of payment.jsp

        HttpSession session = request.getSession();

        MongoDB mongoDB = new MongoDB();

        if (request.getParameter("topUp") != null) {

            Integer cardID = Integer.parseInt(request.getParameter("topUp"));

            session.setAttribute("cardID",cardID);

            CardDAO cardDAO = new CardDAO(mongoDB.openConnection());

            Card chosenCard = cardDAO.getCard(cardID);

            session.setAttribute("chosenCard", chosenCard);

        }else{
            Integer cardID = (Integer) session.getAttribute("cardID");

            CardDAO cardDAO = new CardDAO(mongoDB.openConnection());

            Card chosenCard = cardDAO.getCard(cardID);

            session.setAttribute("chosenCard", chosenCard);

        }


        PaymentDAO paymentDAO = new PaymentDAO(mongoDB.openConnection());

        User user = (User) session.getAttribute("currentUser");

        String userEmail = user.getEmail();

        Payment paymentCard = paymentDAO.getPaymentInfo(userEmail);

        session.setAttribute("paymentCard", paymentCard);

        request.getRequestDispatcher("./payment.jsp").forward(request, response);
    }
}
