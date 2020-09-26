package com.app.asd.Controller;

import com.app.asd.Utils.dbConnect;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class checkEmailUniqueController extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        BasicDBObject obj = new BasicDBObject("email", email);
        MongoCursor<Document> cursor = dbConnect.queryCursor("User", obj);
        PrintWriter out = resp.getWriter();
        if (cursor.hasNext()) out.write("true");
        else out.write("false");
        out.close();
    }
}
