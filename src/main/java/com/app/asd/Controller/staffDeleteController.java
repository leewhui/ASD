package com.app.asd.Controller;

import com.app.asd.Utils.dbConnect;
import com.mongodb.client.result.DeleteResult;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class staffDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteIds = req.getParameter("deleteIds");
        String[] deleteCards = deleteIds.split(",");
        Bson filter;
        int counter = 0;
        for (int i = 0; i < deleteCards.length; i++) {
            counter++;
            filter = eq("_id", new ObjectId(deleteCards[i]));
            dbConnect.removeOne("Card", filter);
        }

        if (counter == deleteCards.length) {
            System.out.println(counter);
            resp.sendRedirect("index.jsp");
        }

    }
}
