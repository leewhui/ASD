package com.app.asd.Controller;

import com.app.asd.Model.Card;
import com.app.asd.Utils.dbConnect;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.JsonArray;
import com.google.appengine.repackaged.com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class staffController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        MongoCursor<Document> resultList = dbConnect.findAll("Card");
        List<Card> cardList = new ArrayList<>();
        while (resultList.hasNext())
        {
            Document document = resultList.next();
            Card card = gson.fromJson(document.toJson(), Card.class);
            card.setID(document.getObjectId("_id").toString());

            cardList.add(card);
        }
        PrintWriter out = resp.getWriter();
        String string = gson.toJson(cardList);
        JsonArray jsonArray = new JsonParser().parse(string).getAsJsonArray();

        out.println(jsonArray);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
