package com.app.asd.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.app.asd.model.*;
import com.app.asd.dao.DBManager;


@WebServlet(name = "orderMenuController", urlPatterns = {"/Controller/orderMenuController"})
public class orderMenuController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet");
        req.setCharacterEncoding("UTF-8");
        resp.sendRedirect("../orderMenu.jsp");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     *
     * @author Shawn
     */
/*
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
        {
            HttpSession session = request.getSession();
            DBManager manager = (DBManager) session.getAttribute("manager");

            ArrayList<Order> itemList = null;
            try {
                itemList = manager.fetchOrder();
                if (itemList != null) {
                    session.setAttribute("itemList",itemList);
                    request.getRequestDispatcher("../orderMenu.jsp").include(request,response);
                }
                else {
                    session.setAttribute("existErr", "Item not exsit");
                    request.getRequestDispatcher("../orderMenu.jsp").include(request,response);
                }

            }
            catch (SQLException ex) {
                Logger.getLogger(orderMenuController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
            }

            //request.getRequestDispatcher("showItem.jsp").include(request,response);
        }

 */

}

