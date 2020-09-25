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

public class processingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer cardID = (Integer) session.getAttribute("cardID");

        MongoDB mongoDB = new MongoDB();

        CardDAO cardDAO = new CardDAO(mongoDB.openConnection());

        Card chosenCard = cardDAO.updateBalance(cardID);

        //Card chosenCard = new Card(cardID, userID);

        //session.setAttribute("chosenCard", chosenCard);

        request.getRequestDispatcher("./afterPayment.jsp").forward(request, response);
    }


}
