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

public class processingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Comment: this servlet process different results based of pressed different button.
        // delete= delete the payment info from database;
        // autoSave = add payment info to database;
        // confirm = process the top up

        HttpSession session = request.getSession();

        MongoDB mongoDB = new MongoDB();

        if(request.getParameter("delete") != null)
        {
            PaymentDAO paymentDAO = new PaymentDAO(mongoDB.openConnection());

            User user = (User) session.getAttribute("currentUser");

            String userEmail = user.getEmail();

            paymentDAO.deletePaymentInfo(userEmail);

            request.getRequestDispatcher("./paymentServlet").forward(request, response);
        }


        if(request.getParameter("confirm") != null){

            String moneyCheck = request.getParameter("payment");

            if(moneyCheck != null && moneyCheck.length() >0){

                double money = Double.parseDouble(request.getParameter("payment"));

                Integer cardID = (Integer) session.getAttribute("cardID");

                CardDAO cardDAO = new CardDAO(mongoDB.openConnection());

                Card chosenCard = cardDAO.updateBalance(cardID,money);
            }


            if (request.getParameter("autoSaved") != null) {

                PaymentDAO paymentDAO = new PaymentDAO(mongoDB.openConnection());

                String cardName = request.getParameter("cardName");

                String creditCardNumber = request.getParameter("creditCardNumber");

                String validDate = request.getParameter("validDate");

                String CVV = request.getParameter("CVV");

                User user = (User) session.getAttribute("currentUser");

                String userEmail = user.getEmail();

                paymentDAO.addPaymentInfo(cardName, creditCardNumber, validDate, CVV, userEmail);

            }

            request.getRequestDispatcher("./afterPayment.jsp").forward(request, response);
        }




    }


}
