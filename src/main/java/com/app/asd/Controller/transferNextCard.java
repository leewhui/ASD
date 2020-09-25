package com.app.asd.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class transferNextCard extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer selectFirstCard = Integer.parseInt(request.getParameter("transfer"));

        session.setAttribute("selectFirstCard", selectFirstCard);

            request.getRequestDispatcher("transferNextCard.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}