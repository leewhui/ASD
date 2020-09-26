package com.app.asd.Controller;

import com.app.asd.Model.User;
import com.app.asd.Utils.dbConnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the current User
        User user = (User)req.getSession().getAttribute("currentUser");
        if(user != null) {
            req.getRequestDispatcher("userInfo.jsp").include(req, resp);
        } else {
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the user infomation
        User user = (User)req.getSession().getAttribute("currentUser");
        user.setFirst_name(req.getParameter("firstName"));
        user.setLast_name(req.getParameter("lastName"));
        user.setDob(req.getParameter("dob"));
        user.setEmail(req.getParameter("email"));
        user.setGender(req.getParameter("gender"));
        // Save to MongoDB.
        if(dbConnect.updateOneUser(user).equals("success")) {
            req.setAttribute("success", true);
        } else {
            req.setAttribute("success", false);
        }
        req.setAttribute("userInfo", user);
        req.getRequestDispatcher("userInfo.jsp").include(req, resp);
    }

}
