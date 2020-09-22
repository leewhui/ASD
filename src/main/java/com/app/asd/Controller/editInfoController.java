package com.app.asd.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.app.asd.Utils.dbConnect;
import com.app.asd.module.User;
import com.app.asd.module.dao.JGDBC;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import com.app.asd.module.dao.adminHomeDao;

public class editInfoController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String type = req.getParameter("type");
        JGDBC jgdbc = new JGDBC();
        adminHomeDao con = new adminHomeDao(jgdbc.openConnection());

        if (type.equals("1")) {
            String userID = req.getParameter("userID");

            User finded = con.getSearch(userID);

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
