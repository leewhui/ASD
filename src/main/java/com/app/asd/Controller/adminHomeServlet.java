package com.app.asd.Controller;

import com.app.asd.Model.User;
import com.app.asd.Model.dao.adminHomeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class adminHomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //get the "show all user request" from "adminHome.jsp" and get the BD information,which contain all the user, then send to "adminHome.jsp" to show in the table
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminHomeDao con = (adminHomeDao) req.getSession().getAttribute("con");

        req.setCharacterEncoding("UTF-8");
        User[] users = con.getAllUser();
        req.setAttribute("users", users);
        req.getRequestDispatcher("adminHome.jsp").forward(req, resp);

    }
}
