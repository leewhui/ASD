package com.app.asd.Controller;

import com.app.asd.Model.Card;
import com.app.asd.Utils.DAO.CardDAO;
import com.app.asd.Utils.DAO.MongoDB;

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

        HttpSession session = request.getSession();

        Integer cardID = Integer.parseInt(request.getParameter("topUp"));

        MongoDB mongoDB = new MongoDB();

        CardDAO cardDAO = new CardDAO(mongoDB.openConnection()); // Use CardDAO for card payment function

        Card chosenCard = cardDAO.getCard(cardID);

        session.setAttribute("chosenCard", chosenCard);

        request.getRequestDispatcher("./payment.jsp").forward(request, response);
    }
}
