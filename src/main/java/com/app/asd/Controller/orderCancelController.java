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

@WebServlet(name = "orderCancelController", urlPatterns = {"/Controller/orderCancelController"})

public class orderCancelController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Gson gson = new Gson();

        resp.sendRedirect("../orderCancel.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Gson gson = new Gson();

        session.setAttribute("orderCancelMessage","");
        User user = (User) session.getAttribute("currentUser");

        String operation = req.getParameter("operation");

        switch(operation)
        {
            case "C":
                String userSelection = req.getParameter("orderCancel");
                if (userSelection.equals("Choose..."))
                {
                    session.setAttribute("orderCancelMessage","Please Choose an Order to Cancel");
                    req.getRequestDispatcher("../orderCancel.jsp").forward(req, resp);
                    session.setAttribute("orderCancelMessage","");
                }
                else
                {
                    String[] sArray = userSelection.split(" "); // Split the result from <select> "orderID orderCardType"
                    String cancelOrderID = sArray[0];                  // The first element in the split array will be the Order ID

                    Document filter = new Document();
                    filter.append("orderID", cancelOrderID);

                    Document update = new Document();
                    update.append("$set", new Document("orderStatus", "Canceled")); // Update the order status of one order in MongoDB

                    dbConnect.updateOne("Order",filter, update);

                    session.setAttribute("orderCancelMessage","Order Canceled Successfully");
                    req.getRequestDispatcher("../orderCancel.jsp").forward(req, resp);
                    session.setAttribute("orderCancelMessage","");

                }

                break;


            case "A":

                int deleteCount = 0;

                MongoCursor<Document> cancelResult = dbConnect.findAll("Order");
                while (cancelResult.hasNext())
                {
                    Order order = gson.fromJson(cancelResult.next().toJson(), Order.class);
                    if (order.getOrderStatus().equals("Canceled"))
                    {
                        deleteCount += 1;
                    }
                }

                // Delete all canceled orders in the MongoDB
                for (int i = 0; i < deleteCount ; i++)
                {
                    Document delete = new Document();
                    delete.append("orderStatus", "Canceled");

                    dbConnect.deleteOne("Order", delete);
                }

                session.setAttribute("orderCancelMessage","All canceled orders have been deleted");
                req.getRequestDispatcher("../orderCancel.jsp").forward(req, resp);
                session.setAttribute("orderCancelMessage","");

                break;
        }






    }



}
