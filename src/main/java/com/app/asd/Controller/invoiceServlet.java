package com.app.asd.Controller;

import com.app.asd.Utils.DAO.*;
import com.app.asd.module.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class invoiceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer userID = 12345678;

        MongoDB mongoDB = new MongoDB();

        PaymentDAO paymentDAO = new PaymentDAO(mongoDB.openConnection());

        Payment result = paymentDAO.getInvoice(userID);

        session.setAttribute("invoice", result);

        request.getRequestDispatcher("./invoice.jsp").forward(request, response);


       /* HttpSession session = request.getSession();

        Integer cardID = (Integer) session.getAttribute("cardID");

        MongoDB mongoDB = new MongoDB();

        CardDAO cardDAO = new CardDAO(mongoDB.openConnection());

        Card chosenCard = cardDAO.updateBalance(cardID);

        //Card chosenCard = new Card(cardID, userID);

        //session.setAttribute("chosenCard", chosenCard);

        request.getRequestDispatcher("./afterPayment.jsp").forward(request, response);*/
    }


}
