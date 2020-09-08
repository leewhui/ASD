package com.app.asd.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.asd.Utils.MD5Util;
import com.app.asd.Utils.dbConnect;
import org.bson.Document;
import java.io.IOException;

public class signupController extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");
        Document document = new Document("username", username);
        document.append("email", email);
        document.append("password", MD5Util.digest(password));
        document.append("first_name", first_name);
        document.append("last_name", last_name);
        document.append("gender", gender);
        document.append("dob", dob);
        String result = dbConnect.insertOneDocument("User", document);
        if (result.equals("success"))
        {
            System.out.println("success");
            req.setAttribute("isSignUp","Sign up success");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        else
        {
            System.out.println("fail");
            req.setAttribute("isSignUp", "Sign up fail");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }
    }
}
