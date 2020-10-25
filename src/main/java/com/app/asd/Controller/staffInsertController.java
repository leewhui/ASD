package com.app.asd.Controller;

import com.app.asd.Model.Card;
import com.app.asd.Utils.dbConnect;
import com.google.gson.Gson;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class staffInsertController extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardType = req.getParameter("cardType");
        if(cardType.equals("Gold Senior"))
        {
            cardType = "Senior";
        }
        if(cardType.equals("Youth"))
        {
            cardType = "Child";
        }
        
        double initialBal = 0;

        int cardID = -1;
        long opalCardNumber = -1;
        Gson gson = new Gson();

        MongoCursor<Document> cardList = dbConnect.findAll("Card");
        while (cardList.hasNext())
        {
            Document document = cardList.next();
            Card card = gson.fromJson(document.toJson(), Card.class);
            if (cardID < card.getCardID()) cardID = card.getCardID();
            if (card.getOpalCardNumber() != null && !card.getOpalCardNumber().equals("") && opalCardNumber < Long.parseLong(card.getOpalCardNumber())) opalCardNumber = Long.parseLong(card.getOpalCardNumber());
        }
        String str = String.valueOf((opalCardNumber + 1));

        Document document = new Document("cardID", cardID + 1);
        document.append("opalCardNumber", str);
        document.append("cardType", cardType);
        document.append("cardBalance", initialBal);
        document.append("cardStatus", "Activated");
        document.append("userEmail", null);
        document.append("is_linked", false);
        document.append("is_sold", false);
        dbConnect.insertOneDocument("Card", document);
        resp.sendRedirect("staff.jsp");
    }
}
