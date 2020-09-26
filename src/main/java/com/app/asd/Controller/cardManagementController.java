package com.app.asd.Controller;
import com.app.asd.Utils.dbConnect;
import com.app.asd.Model.Card;
import com.app.asd.Model.User;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.mail.Session.*;

public class cardManagementController extends HttpServlet
{
    //get user data from session, then get card data from database and send the card data to card management page.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Gson gson = new Gson();
        User user = (User) session.getAttribute("currentUser");
        String email = user.getEmail();
        BasicDBObject obj = new BasicDBObject("email", email);
        MongoCursor<Document> resultList = dbConnect.findAll("Card");
        ArrayList<Card> cardList = new ArrayList();
        while(resultList.hasNext())
        {
            Card card = gson.fromJson(resultList.next().toJson(),Card.class);
            cardList.add(card);

        }

        session.setAttribute("card",cardList);
        req.getRequestDispatcher("/cardManagement.jsp").forward(req,resp);



    }

    // get change of card status from user input, then update the data in database.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //HttpSession session = req.getSession();

        String cardStatus_changed = req.getParameter("cardStatus");
        int cardID = Integer.parseInt(req.getParameter("cardID"));

        Document filter = new Document();
        filter.append("cardID", cardID);
        Document update = new Document();
        update.append("$set", new Document("cardStatus",cardStatus_changed));
        dbConnect.updateOne("Card",filter,update);

        req.getRequestDispatcher("/main.jsp").forward(req,resp);

        /*req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Gson gson = new Gson();
        User user = (User) session.getAttribute("currentUser");

        String email = user.getEmail();
        BasicDBObject obj = new BasicDBObject("email", email);

        int cardID = Integer.parseInt(req.getParameter("cardID"));
        String cardNumber = req.getParameter("cardNumber");
        String cardType = req.getParameter("cardType");
        String cardBalance = req.getParameter("cardBalance");
        String cardStatus = req.getParameter("cardStatus");
        String userEmail = req.getParameter("userEmail");
        Boolean is_linked = Boolean.valueOf(req.getParameter("is_linked")).booleanValue();
        Boolean is_sold = Boolean.valueOf(req.getParameter("is_sold")).booleanValue();

        //dbConnect.editCardStatus(cardID, cardNumber,cardType, cardBalance, cardStatus, userEmail,is_linked, is_sold);
        /*ArrayList<Card> cardList = new ArrayList();
        while(resultList.hasNext())
        {
            Card card = gson.fromJson(resultList.next().toJson(),Card.class);
            cardList.add(card);
        }*/

        //session.setAttribute("card",cardList);
        //req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }
}
