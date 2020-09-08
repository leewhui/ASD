package com.app.asd.Controller;
import com.app.asd.Utils.MD5Util;
import com.app.asd.Utils.dbConnect;
import com.app.asd.module.User;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        String email = req.getParameter("email");
        String password = MD5Util.digest(req.getParameter("password"));
        BasicDBObject obj = new BasicDBObject("email", email);
        MongoCursor<Document> resultList = dbConnect.queryCursor("User", obj);
        if (!resultList.hasNext())
        {
            req.setAttribute("LoginStatus","User not exist");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        else
        {
            while (resultList.hasNext()) {
                User user = gson.fromJson(resultList.next().toJson(), User.class);
                if (user.getEmail().equals(email) && user.getPassword().equals(password))
                {
                    if (user.isIs_staff())
                    {
                        System.out.println("1");
                        req.setAttribute("LoginStatus",user);
                        req.getRequestDispatcher("admin.jsp").forward(req, resp);
                    }
                    else
                    {
                        System.out.println("2");
                        req.setAttribute("LoginStatus",user);
                        HttpSession session = req.getSession();
                        session.setAttribute("currentUser", user);
                        req.getRequestDispatcher("./jsp/main.jsp").forward(req, resp);
                    }
                }
                else
                {
                    System.out.println("123");
                    req.setAttribute("LoginStatus","Password is incorrect");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }
        }
        resp.sendRedirect("./jsp/main.jsp");
    }
}
