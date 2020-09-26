package com.app.asd.Controller;

import com.app.asd.Utils.MD5Util;
import com.app.asd.Utils.dbConnect;
import com.app.asd.Model.*;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "orderMenuController", urlPatterns = {"/Controller/orderMenuController"})
public class orderMenuController extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Gson gson = new Gson();

        User user = (User) session.getAttribute("currentUser");
        String userEmail = user.getEmail();
        boolean isStaff = user.isIs_staff();

        // If the current user is staff, then all orders in the database will be added into the list
        if(isStaff) 
        {
            MongoCursor<Document> result = dbConnect.findAll("Order");
            ArrayList<Order> temp1 = new ArrayList();
            if (!result.hasNext())
            {

            }
            else
            {
                while (result.hasNext())
                {
                    Order order = gson.fromJson(result.next().toJson(), Order.class);
                    temp1.add(order);
                }
            }
            session.setAttribute("OrderList",temp1);
            req.getRequestDispatcher("/orderMenu.jsp").forward(req, resp);
        }
        else // If the current user is customer, then only the orders of the current customer will be added into the list
        {
            BasicDBObject obj = new BasicDBObject("userEmail", userEmail);
            MongoCursor<Document> resultList = dbConnect.queryCursor("Order", obj);

            ArrayList<Order> temp = new ArrayList();
            if (!resultList.hasNext())
            {


            }
            else
            {
                while (resultList.hasNext())
                {
                    Order order = gson.fromJson(resultList.next().toJson(), Order.class);
                    temp.add(order);
                }
            }

            session.setAttribute("OrderList",temp);
            req.getRequestDispatcher("/orderMenu.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("servlet");
        // req.setCharacterEncoding("UTF-8");

    }
}
