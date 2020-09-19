package com.app.asd.Controller;

import com.app.asd.Utils.DAO.MongoDB;
import com.app.asd.Utils.DAO.PaymentDAO;
import com.app.asd.module.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class paymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //String param1 = request.getParameter("paymentID");

        int paymentID = Integer.parseInt((String)request.getParameter("paymentID"));

        MongoDB mongoDB = new MongoDB();

        PaymentDAO paymentDAO = new PaymentDAO(mongoDB.openConnection());

        Payment result = paymentDAO.getPaymentBalance(paymentID);


        if (result != null) {
            double paymentBalance =  result.getPaymentBalance();
            request.setAttribute("balance", paymentBalance);
        }else{
            double paymentBalance = 0;
            request.setAttribute("balance", paymentBalance);
        }

        request.getRequestDispatcher("./transfer.jsp").forward(request, response);
        System.out.println(result.getPaymentBalance());
        System.out.println(paymentID);

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
