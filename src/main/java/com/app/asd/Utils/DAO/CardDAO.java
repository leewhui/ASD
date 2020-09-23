package com.app.asd.Utils.DAO;

import com.app.asd.module.Payment;
import com.mongodb.*;
import org.bson.types.ObjectId;
import com.app.asd.module.Card;

import java.util.Arrays;
import java.util.Date;

public class CardDAO {
    MongoClient mongoClient;
    DB database;
    DBCollection collection;

    public CardDAO(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        database = mongoClient.getDB("ASD");
        collection = database.getCollection("Card");
    }

    public void setDatabase(DB database) {
        this.database = database;
    }

    public Card getCard(int cardID){

        //BasicDBObject allQuery = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        fields.put("cardID", cardID);

        DBCursor cursor = collection.find(fields);
        DBObject result = cursor.one();
        while (cursor.hasNext()) {

            int newCardID = (int)result.get("cardID");
            String opalCardNumber = (String)result.get("opalCardNumber");
            String cardType = (String)result.get("cardType");
            double cardBalance = (double)result.get("cardBalance");
            String cardStatus = (String)result.get("cardStatus");
            int userID = (int)result.get("userID");

            return new Card(newCardID, opalCardNumber, cardType, cardBalance, cardStatus,userID);
        }
        return null;
    }

    public Card[] getCards(int userID){

        //BasicDBObject allQuery = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        fields.put("userID", userID);

        DBCursor cursor = collection.find(fields);
        Card[] card = new Card[cursor.count()];
        int count = 0;

        while (cursor.hasNext()) {
            DBObject result = cursor.next();
            int cardID = (int)result.get("cardID");
            String opalCardNumber = (String)result.get("opalCardNumber");
            String cardType = (String)result.get("cardType");
            double cardBalance = (double)result.get("cardBalance");
            String cardStatus = (String)result.get("cardStatus");
            int newUserID = (int)result.get("userID");
            card[count] = new Card(cardID, opalCardNumber, cardType, cardBalance, cardStatus,newUserID);
            count++;
        }
        return card;
    }

    public Card updateBalance(int cardID){

        //BasicDBObject allQuery = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        fields.put("cardID", cardID);

        DBCursor cursor = collection.find(fields);
        DBObject result = cursor.one();
        while (cursor.hasNext()) {

            int newCardID = (int)result.get("cardID");
            String opalCardNumber = (String)result.get("opalCardNumber");
            String cardType = (String)result.get("cardType");
            double cardBalance = (double)result.get("cardBalance");
            String cardStatus = (String)result.get("cardStatus");
            int userID = (int)result.get("userID");

            double newBalance = 20 + cardBalance;

            //BasicDBObject records = new BasicDBObject();
            BasicDBObject update = new BasicDBObject();
            update.append("cardID", cardID);
            update.append("opalCardNumber", opalCardNumber);
            update.append("cardType", cardType);
            update.append("cardBalance", newBalance);
            update.append("cardStatus", cardStatus);
            update.append("userID", userID);
            collection.update(fields, update);

            return new Card(newCardID, opalCardNumber, cardType, newBalance, cardStatus,userID);
        }
        return null;
    }
}
