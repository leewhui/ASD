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

public class cardStatusServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Comment: this servlet retrieve all data of card,then process to next page (transfer or top up)

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("currentUser");

        String userEmail = user.getEmail();

        MongoDB mongoDB = new MongoDB();

        CardDAO cardDAO = new CardDAO(mongoDB.openConnection());

        Card[] result = cardDAO.getCards(userEmail);

        session.setAttribute("cards", result);

        if (request.getParameter("topUp") != null) {

        request.getRequestDispatcher("./cardStatus.jsp").forward(request, response);

        }else if(request.getParameter("transfer") != null){

        request.getRequestDispatcher("./transfer.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request, response);
    }
}
