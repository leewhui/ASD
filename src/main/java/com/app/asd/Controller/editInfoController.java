package com.app.asd.Controller;

import com.app.asd.Model.User;
import com.app.asd.Model.Card;
import com.app.asd.Model.dao.adminHomeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        adminHomeDao conCard = (adminHomeDao) req.getSession().getAttribute("conCard");
        String email = req.getParameter("userEmail");
        switch (type) {
            case "search user": { //dealing the request from search function at navbar
                User finded = con.getSearch(email);
                req.setAttribute("finded", finded);
                req.setAttribute("type", "search");
                req.getRequestDispatcher("editInfo.jsp").forward(req, resp);
                break;
            }
            case "editing user": { // dealing the request from editInfo.jsp
                String password = req.getParameter("password");
                String firstname = req.getParameter("firstname");
                String lastname = req.getParameter("lastname");
                String is_staff = req.getParameter("is_staff");
                String phone = req.getParameter("phone");
                String gender = req.getParameter("gender");
                String dob = req.getParameter("dob");
                String date = req.getParameter("date");
                String act = req.getParameter("act");
                String username = req.getParameter("username");

                con.editUser(password, firstname, lastname, is_staff, phone, email, gender, dob, date, act, username);
                req.setAttribute("type", "good");
                req.getRequestDispatcher("editInfo.jsp").forward(req, resp);
                break;
            }
            case "deteing user":  //delete a user.
                con.delUser(email);
                req.getRequestDispatcher("adminHome.jsp").forward(req, resp);
                break;
            case "adding user": { //dealing the request from adminCreateUser.jsp

                String password = req.getParameter("password");
                String firstname = req.getParameter("firstname");
                String lastname = req.getParameter("lastname");
                String is_staff = req.getParameter("is_staff");
                String phone = req.getParameter("phone");
                String gender = req.getParameter("gender");
                String dob = req.getParameter("dob");

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String date = df.format(new Date());

                String act = req.getParameter("act");
                String username = req.getParameter("username");

                con.addUser(email, password, firstname, lastname, is_staff, phone, gender, dob, date, act, username);
                req.setAttribute("type", "good");
                req.getRequestDispatcher("adminCreateUser.jsp").forward(req, resp);
                break;
            }
            case "edit Account search": { //dealing the request from editAccount.jsp
                User finded = con.getSearch(email);
                Card[] cards = conCard.getAllCard(email);
                req.setAttribute("finded", finded);
                req.setAttribute("cards", cards);
                req.setAttribute("type", "search");

                req.getRequestDispatcher("editAccount.jsp").forward(req, resp);

                break;
            }
            case "editing card":  //dealing the request from editAccount.jsp

                String opgn = req.getParameter("opgn");
                String balance = req.getParameter("balance");
                String cardType = req.getParameter("cardType");
                String cardStatus = req.getParameter("cardStatus");

                conCard.editCard(opgn, balance, cardType, cardStatus);

                req.setAttribute("type", "good");
                req.getRequestDispatcher("editAccount.jsp").forward(req, resp);

                break;
        }
    }




}
