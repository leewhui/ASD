package com.app.asd.Controller;

import com.app.asd.Utils.DAO.MongoDB;
import com.app.asd.Utils.DAO.CardDAO;
import com.app.asd.module.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class cardStatusServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //int userID = 1000001;
        HttpSession session = request.getSession();

        Integer userID = (Integer)session.getAttribute("userID");

        MongoDB mongoDB = new MongoDB();

        CardDAO cardDAO = new CardDAO(mongoDB.openConnection());

        Card[] result = cardDAO.getCards(userID);

        if (result != null) {
        //for(int i=0; i<= result.length; i++) {
           /* int cardID = result[i].getCardID();
            String opalCardNumber = result[i].getOpalCardNumber();
            String cardType = result[i].getCardType();
            double cardBalance = result[i].getCardBalance();
            String cardStatus = result[i].getCardStatus();*/

        session.setAttribute("cards", result);
        request.getRequestDispatcher("./cardStatus.jsp").forward(request, response);
        }else{
        request.getRequestDispatcher("./linkCard.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request, response);
        /*String param1 = request.getParameter("paymentID");

        if(param1.equals(12345678)) {
            request.getRequestDispatcher("./transfer.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("./payment.jsp").forward(request, response);
        }*/
    }
}
