package com.app.asd.Controller;

import com.app.asd.Model.Order;
import com.app.asd.Utils.dbConnect;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
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

        String operation = req.getParameter("operation"); // Use "operation" parameter to decide the function

        switch(operation)
        {
            case "R":

                String orderID = req.getParameter("orderID"); // Get the current selected order ID 
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

                if (orderStatus_Changed.equals("Choose..."))
                {
                    session.setAttribute("orderStatusMessage","Please select the order status to change");
                }
                else
                {
                    Document filter = new Document();
                    filter.append("orderID", currentOrderID);

                    Document update = new Document();
                    update.append("$set", new Document("orderStatus", orderStatus_Changed)); // Update the order status of one order in MongoDB

                    dbConnect.updateOne("Order",filter, update);

                    session.setAttribute("orderStatusMessage","Order Status Updated Successfully");
                }

                req.getRequestDispatcher("../orderManage.jsp").forward(req, resp);
                session.setAttribute("orderStatusMessage","");
                break;


            case "D":
                String deleteOrderID = req.getParameter("orderID");

                Document delete = new Document();
                delete.append("orderID", deleteOrderID);

                dbConnect.deleteOne("Order", delete); // Delete the corresponding order in MongoDB

                session.setAttribute("orderStatusMessage","Order has been Deleted");
                req.getRequestDispatcher("../orderManage.jsp").forward(req, resp);
                session.setAttribute("orderStatusMessage","");

                break;
        }


    }



}
