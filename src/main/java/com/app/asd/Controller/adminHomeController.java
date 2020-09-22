package com.app.asd.Controller;

import com.app.asd.Model.User;
import com.app.asd.Model.dao.adminHomeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class adminHomeController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userEmail = req.getParameter("userEmail");

        adminHomeDao con =(adminHomeDao) req.getSession().getAttribute("con");
        User finded = con.getSearch(userEmail);

        req.setAttribute("finded", finded);
        req.getRequestDispatcher("adminShow.jsp").forward(req, resp);


    }


}
