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

public class linkController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String cardNumber = req.getParameter("cardNumber");
        User user = (User)req.getSession().getAttribute("currentUser");

        BasicDBObject obj = new BasicDBObject("opalCardNumber", cardNumber);
        MongoCursor<Document> resultList = dbConnect.queryCursor("Card", obj);
        Card card = null;
        Gson gson = new Gson();
        if(resultList.hasNext()){
            card = gson.fromJson(resultList.next().toJson(), Card.class);
        } else {
            String page = action.equals("link")?"linkCard.jsp":"unlinkCard.jsp";
            resp.sendRedirect( page + "?error=Card number does not exist.");
            return;
        }

        Document filter = new Document();
        filter.append("opalCardNumber", cardNumber);
        Document update = new Document();
        if(action.equals("link")){
            if(card.getUserEmail() == null){
                update.append("$set", new Document("userEmail", user.getEmail()));
            } else {
                resp.sendRedirect("linkCard.jsp?error=The card has already been linked.");
                return;
            }
        } else {
            if(user.getEmail().equals(card.getUserEmail())){
                update.append("$set", new Document("userEmail", null));
            } else {
                resp.sendRedirect("unlinkCard.jsp?error=Cannot unlink a card that does not belong to you.");
                return;
            }
        }
        dbConnect.updateOne("Card",filter,update);
        resp.sendRedirect("editProfile");
    }
}
