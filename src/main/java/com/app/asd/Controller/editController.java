package com.app.asd.Controller;

import com.app.asd.Model.Card;
import com.app.asd.Model.User;
import com.app.asd.Utils.dbConnect;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class editController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the current User
        User user = (User)req.getSession().getAttribute("currentUser");
        if(user != null) {
            BasicDBObject obj = new BasicDBObject("userEmail", user.getEmail());
            MongoCursor<Document> resultList = dbConnect.queryCursor("Card", obj);//query 'Card' from MongoDB
            List<Card> cards = new ArrayList<>();//get cards list
            Gson gson = new Gson();
            while(resultList.hasNext()){
                cards.add(gson.fromJson(resultList.next().toJson(), Card.class));
            }
            req.setAttribute("cards", cards);
            req.getRequestDispatcher("userInfo.jsp").include(req, resp);
        } else {
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the user information
        User user = (User)req.getSession().getAttribute("currentUser");
        if(user != null) {
            BasicDBObject obj = new BasicDBObject("userEmail", user.getEmail());
            MongoCursor<Document> resultList = dbConnect.queryCursor("Card", obj);//query 'Card' from MongoDB
            //get cards list
            List<Card> cards = new ArrayList<>();
            Gson gson = new Gson();
            //set attributes
            while(resultList.hasNext()){
                cards.add(gson.fromJson(resultList.next().toJson(), Card.class));
            }
            // Set updated user info
            user.setFirst_name(req.getParameter("firstName"));
            user.setLast_name(req.getParameter("lastName"));
            user.setDob(req.getParameter("dob"));
            user.setPassword(req.getParameter("password"));
            user.setGender(req.getParameter("gender"));
            
            // Save to MongoDB.
            if(dbConnect.updateOneUser(user).equals("success")) {
                req.setAttribute("success", true);
            } else {
                req.setAttribute("success", false);
            }
            req.setAttribute("cards", cards);
            req.getRequestDispatcher("userInfo.jsp").include(req, resp);
        } else {
            resp.sendRedirect("login.jsp");
        }

    }

}
