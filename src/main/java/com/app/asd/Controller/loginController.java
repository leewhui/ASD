package com.app.asd.Controller;
import com.app.asd.Utils.dbConnect;
import com.app.asd.Model.User;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

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
        // get paramaters from the front-end
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("checkbox");
        // find the user by the email
        BasicDBObject obj = new BasicDBObject("email", email);
        MongoCursor<Document> resultList = dbConnect.queryCursor("User", obj);
        if (!resultList.hasNext()) // if there is no user found from the database
        {
            String message = "User not exist";
            req.setAttribute("LoginStatus",message);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        else
        {
            // if the user exist
            while (resultList.hasNext()) {
                User user = gson.fromJson(resultList.next().toJson(), User.class);
                // check wheather email and password match
                if (user.getEmail().equals(email) && user.getPassword().equals(password))
                {
                    if ("admin@gmail.com".equals(user.getEmail())) // if staff login jump to the admin page
                    {
                        req.setAttribute("LoginStatus",user);
                        req.getRequestDispatcher("/adminHome.jsp").forward(req, resp);
                    }
                    else
                    {
                        // add cookie for the user if the user click the remember be check box
                        if ("on".equals(remember))
                        {
                            Cookie cookie1 = new Cookie("email", email);
                            Cookie cookie2 = new Cookie("password", req.getParameter("password"));
                            cookie1.setMaxAge(30);
                            cookie2.setMaxAge(30);
                            resp.addCookie(cookie1);
                            resp.addCookie(cookie2);
                        }
                        // normal user login, jump to the main page
                        req.setAttribute("LoginStatus",user);
                        HttpSession session = req.getSession();
                        session.setAttribute("currentUser", user);
                        resp.sendRedirect("main.jsp");
                    }
                }
                else
                {
                    // password not found
                    req.setAttribute("LoginStatus","Password is incorrect");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            }
        }
    }
}
