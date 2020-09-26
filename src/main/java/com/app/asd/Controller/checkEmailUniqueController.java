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
        // query the email which come from the front-end
        MongoCursor<Document> cursor = dbConnect.queryCursor("User", obj);
        PrintWriter out = resp.getWriter();
        if (cursor.hasNext()) out.write("true"); // if the email exist, print true.
        else out.write("false"); // if not found the email, print false
        out.close();
    }
}
