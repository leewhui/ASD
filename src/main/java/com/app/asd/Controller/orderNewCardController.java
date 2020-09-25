package com.app.asd.Controller;

import com.app.asd.Model.*;
import com.app.asd.Utils.MD5Util;
import com.app.asd.Utils.dbConnect;
import com.google.gson.Gson;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet(name = "orderNewCardController", urlPatterns = {"/Controller/orderNewCardController"})
public class orderNewCardController extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Gson gson = new Gson();

        User user = (User) session.getAttribute("currentUser");
        String Email = user.getEmail();

        int lastOrderID = 0;
        MongoCursor<Document> result = dbConnect.findAll("Order");
        if (!result.hasNext())
        {

        }
        else
        {
            while (result.hasNext()) {
                Order order = gson.fromJson(result.next().toJson(), Order.class);
                lastOrderID = Integer.parseInt(order.getOrderID());
            }
        }

        int newOrderID = lastOrderID + 1;

        String newOrderDateTime;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        newOrderDateTime = formatter.format(date);


        String orderID =  newOrderID + "" ;
        String userEmail = Email;
        String orderDate = newOrderDateTime;
        String orderStatus = "Submitted";
        String orderCardType = req.getParameter("orderCardType");
        String deliveryAddress = req.getParameter("deliveryAddress");
        String deliveryPostcode = req.getParameter("deliveryPostcode");
        String orderComment = req.getParameter("orderComment");

        Document document = new Document("orderID", orderID);
        document.append("userEmail", userEmail);
        document.append("orderDate", orderDate);
        document.append("orderStatus", orderStatus);
        document.append("orderCardType", orderCardType);
        document.append("deliveryAddress", deliveryAddress);
        document.append("deliveryPostcode", deliveryPostcode);
        document.append("orderComment", orderComment);

        dbConnect.insertOneDocument("Order", document);

        session.setAttribute("NewOrderMessage", "New Order Submitted Successfully");
        req.getRequestDispatcher("../orderNewCard.jsp").forward(req, resp);
        session.setAttribute("NewOrderMessage", null);
    }

}
