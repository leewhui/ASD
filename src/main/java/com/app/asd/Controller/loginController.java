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
import javax.servlet.http.*;
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
        String remember = req.getParameter("checkbox");
        BasicDBObject obj = new BasicDBObject("email", email);
        MongoCursor<Document> resultList = dbConnect.queryCursor("User", obj);
        if (!resultList.hasNext())
        {
            String message = "User not exist";
            req.setAttribute("LoginStatus",message);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        else
        {
            while (resultList.hasNext()) {
                User user = gson.fromJson(resultList.next().toJson(), User.class);
                if (user.getEmail().equals(email) && user.getPassword().equals(password))
                {
                    if (user.isIs_staff())
                    {
                        req.setAttribute("LoginStatus",user);
                        req.getRequestDispatcher("/login.jsp").forward(req, resp);
                    }
                    else
                    {
                        if ("on".equals(remember))
                        {
                            Cookie cookie1 = new Cookie("email", email);
                            Cookie cookie2 = new Cookie("password", req.getParameter("password"));
                            cookie1.setMaxAge(30);
                            cookie2.setMaxAge(30);
                            resp.addCookie(cookie1);
                            resp.addCookie(cookie2);
                        }
                        req.setAttribute("LoginStatus",user);
                        HttpSession session = req.getSession();
                        session.setAttribute("currentUser", user);
                        req.getRequestDispatcher("/main.jsp").forward(req, resp);
                    }
                }
                else
                {
                    req.setAttribute("LoginStatus","Password is incorrect");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            }
        }
    }
}
