package com.app.asd.Controller;

import com.app.asd.Utils.dbConnect;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.mongodb.client.model.Filters.eq;

public class staffUpdateController extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("ID");
        int cardID = Integer.parseInt(req.getParameter("cardID"));
        String opalCardNumber = req.getParameter("opalCardNumber");
        String cardType = req.getParameter("cardType");
        double cardBalance = Double.parseDouble(req.getParameter("cardBalance"));
        String cardStatus = req.getParameter("cardStatus");
        String userEmail = req.getParameter("userEmail");
        boolean is_linked = Boolean.parseBoolean(req.getParameter("is_linked"));
        boolean is_sold = Boolean.parseBoolean(req.getParameter("is_sold"));

        Bson filter = eq("_id", new ObjectId(id));

        BasicDBObject newDocument = new BasicDBObject();

        newDocument.put("cardID", cardID);
        newDocument.put("opalCardNumber", opalCardNumber);
        newDocument.put("cardType", cardType);
        newDocument.put("cardBalance", cardBalance);
        newDocument.put("cardStatus", cardStatus);
        newDocument.put("userEmail", userEmail);
        newDocument.put("is_linked", is_linked);
        newDocument.put("is_sold", is_sold);

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        dbConnect.updateOne("Card", filter, updateObject);
        resp.sendRedirect("staff.jsp");
    }
}
