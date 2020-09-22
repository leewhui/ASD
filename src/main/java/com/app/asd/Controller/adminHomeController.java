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

public class adminHomeController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userID = req.getParameter("userID");

        JGDBC jgdbc = new JGDBC();
        adminHomeDao con = new adminHomeDao(jgdbc.openConnection());
        User finded = con.getSearch(userID);

        req.setAttribute("finded", finded);
        req.getRequestDispatcher("adminShow.jsp").forward(req, resp);


    }


}
