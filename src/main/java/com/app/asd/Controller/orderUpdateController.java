package com.app.asd.Controller;

import com.app.asd.Model.Order;
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


@WebServlet(name = "orderUpdateController", urlPatterns = {"/Controller/orderUpdateController"})
public class orderUpdateController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Gson gson = new Gson();

        session.setAttribute("orderStatusMessage","");

        String operation = req.getParameter("operation");

        switch(operation)
        {
            case "R":

                String orderID = req.getParameter("orderID");
                MongoCursor<Document> result = dbConnect.findAll("Order");

                while (result.hasNext())
                {
                    Order order = gson.fromJson(result.next().toJson(), Order.class);
                    if (order.getOrderID().equals(orderID))
                    {
                        session.setAttribute("currentOrder",order);

                        break;
                    }
                }
                req.getRequestDispatcher("../orderManage.jsp").forward(req, resp);
                break;

            case "U":
                String orderStatus_Changed = req.getParameter("orderStatus");
                Order order = (Order) session.getAttribute("currentOrder");
                String currentOrderID = order.getOrderID();

                Document filter = new Document();
                filter.append("orderID", currentOrderID);

                Document update = new Document();
                update.append("$set", new Document("orderStatus", orderStatus_Changed));

                dbConnect.updateOne("Order",filter, update);


                session.setAttribute("orderStatusMessage","Order Status Updated Successfully");
                req.getRequestDispatcher("../orderManage.jsp").forward(req, resp);
                session.setAttribute("orderStatusMessage","");
                break;
        }


    }



}
