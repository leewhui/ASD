package com.app.asd.Controller;

import com.app.asd.Model.User;
import com.app.asd.Utils.dbConnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class linkController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet1223");
        //Check the card number;
        User user = (User)req.getSession().getAttribute("currentUser");
        user.setCardNumber(req.getParameter("cardNumber"));
        // Save to MongoDB.
        if(dbConnect.updateOneUser(user).equals("success")) {
            req.setAttribute("success", true);
        } else {
            req.setAttribute("success", false);
        }
        resp.sendRedirect("editProfile");
    }
}
