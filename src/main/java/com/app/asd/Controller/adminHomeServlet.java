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

public class adminHomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        JGDBC jgdbc = new JGDBC();
        adminHomeDao con = new adminHomeDao(jgdbc.openConnection());
        req.setAttribute("con", con);

        User[] users = con.getAllUser();
        req.setAttribute("con", con);
        req.setAttribute("users", users);
        req.getRequestDispatcher("adminHome.jsp").forward(req, resp);

    }


}


//package com.app.asd.Controller;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import com.app.asd.Utils.dbConnect;
//import com.app.asd.module.User;
//import com.app.asd.module.dao.JGDBC;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBCursor;
//import com.mongodb.client.MongoCursor;
//import org.bson.Document;
//import com.app.asd.module.dao.adminHomeDao;
//
//
//public class adminHomeServlet extends HttpServlet{
//
//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        req.setCharacterEncoding("UTF-8");
//        JGDBC jgdbc = new JGDBC();
//        adminHomeDao con = new adminHomeDao(jgdbc.openConnection());
//        req.setAttribute("con",con);
//
//        User[] users = con.getAllUser();
//        req.setAttribute("users",users);
//
//        req.getRequestDispatcher("adminHome.jsp").forward(req,resp);
//        resp.sendRedirect("adminShow.jsp");
//
//    }
//
//
//
//}
