package com.app.asd.Controller;

import com.app.asd.Utils.Order;
import com.app.asd.Utils.dbConnect;
import com.app.asd.Model.*;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

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
        else
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








        /*
        MongoCollection<Document> result = dbConnect.getMongoCollection("Order");
        List<Document> temp = dbConnect.findAll("Order");

        session.setAttribute("OrderList",temp);
        req.getRequestDispatcher("/orderMenu.jsp").forward(req, resp);
        */







        /*
        if (!resultList.hasNext())
        {
            String message = "Order not exist";
            req.setAttribute("OrderStatus",message);
            req.getRequestDispatcher("/orderMenu.jsp").forward(req, resp);
        }
        else
        {
            ArrayList<Order> temp = new ArrayList();

            while (resultList.hasNext()) {
                Order order = gson.fromJson(resultList.next().toJson(), Order.class);
                if (order.getUserEmail().equals(userEmail))
                {
                    req.setAttribute("LoginStatus",order);
                    HttpSession session = req.getSession();
                    session.setAttribute("currentUser", order);
                    req.getRequestDispatcher("/orderMenu.jsp").forward(req, resp);
                }
                else
                {
                    req.setAttribute("LoginStatus","Password is incorrect");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            }
        }
        */

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("servlet");
        // req.setCharacterEncoding("UTF-8");

    }
}
