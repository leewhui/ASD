package com.app.asd.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.asd.Utils.MD5Util;
import com.app.asd.Utils.dbConnect;
import org.bson.Document;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class signupController extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd-MM-yyyy");
        Date date = new Date();
        String date_registered = req.getParameter("date_registered") == null ? sdf.format(date).toString() : req.getParameter("date_registered");
        boolean activated_status = req.getParameter("activated_status") == null ? true : Boolean.parseBoolean(req.getParameter("activated_status"));
        boolean is_staff = req.getParameter("is_staff") == null ? false : Boolean.parseBoolean(req.getParameter("is_staff"));
        Document document = new Document("username", username);
        document.append("email", email);
        document.append("password", password);
        document.append("first_name", first_name);
        document.append("last_name", last_name);
        document.append("gender", gender);
        document.append("dob", dob);
        document.append("date_registered", date_registered);
        document.append("activated_status", activated_status);
        document.append("is_staff", is_staff);
        String result = dbConnect.insertOneDocument("User", document);
        if (result.equals("success"))
        {
            req.setAttribute("isSignUp","Sign up success");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        else
        {
            req.setAttribute("isSignUp", "Sign up fail");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }
    }
}
