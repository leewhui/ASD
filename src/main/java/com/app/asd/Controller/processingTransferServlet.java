package com.app.asd.Controller;

import com.app.asd.Model.*;
import com.app.asd.Utils.DAO.CardDAO;
import com.app.asd.Utils.DAO.MongoDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class processingTransferServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Comment: this servlet processed two cards transfer, it will transfer first card balance to second one selected from database.

        HttpSession session = request.getSession();

        Integer selectFirstCard = (Integer)session.getAttribute("selectFirstCard");

        Integer selectSecondCard = Integer.parseInt(request.getParameter("transfer2"));

        Card[] cards = (Card[])session.getAttribute("cards");

        int firstID = cards[selectFirstCard].getCardID();

        int secondID = cards[selectSecondCard].getCardID();

        MongoDB mongoDB = new MongoDB();

        CardDAO cardDAO = new CardDAO(mongoDB.openConnection());

        Card newCard = cardDAO.transferBalance(firstID,secondID);

        request.getRequestDispatcher("afterTransfer.jsp").forward(request, response);
    }

}

