package com.app.asd.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class logoutController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // when the user logout, destory the session
        HttpSession session = req.getSession();
        session.removeAttribute("currentUser");
        resp.sendRedirect("main.jsp");
    }
}
