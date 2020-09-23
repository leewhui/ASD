package com.app.asd.Controller;

import com.app.asd.Model.User;
import com.app.asd.Model.dao.adminHomeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editInfoController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String type = req.getParameter("type");
        adminHomeDao con = (adminHomeDao) req.getSession().getAttribute("con");

        if (type.equals("1")) {
            String email = req.getParameter("userEmail");

            User finded = con.getSearch(email);

            req.setAttribute("finded", finded);
            req.getRequestDispatcher("editInfo.jsp").forward(req, resp);
        } else if (type.equals("2")) {

            String userID = req.getParameter("userID");
            String password = req.getParameter("password");
            String firstname = req.getParameter("firstname");
            String lastname = req.getParameter("lastname");
            String is_staff = req.getParameter("is_staff");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String gender = req.getParameter("gender");
            String dob = req.getParameter("dob");
            String date = req.getParameter("date");
            String act = req.getParameter("act");
            String username = req.getParameter("username");

            con.editUser(userID, password, firstname, lastname, is_staff, phone, email, gender, dob, date, act, username);

            req.getRequestDispatcher("editInfo.jsp").forward(req, resp);
        }

    }


}
