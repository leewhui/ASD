package com.app.asd.Utils.DAO;

import com.app.asd.Model.Card;
import com.mongodb.*;

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

            //int cardID = (int)result.get("cardID");
            String opalCardNumber = (String)result.get("opalCardNumber");
            String cardType = (String)result.get("cardType");
            double cardBalance = (double)result.get("cardBalance");
            String cardStatus = (String)result.get("cardStatus");
            String userEmail = (String)result.get("userEmail");
            /*boolean is_linked = (boolean)result.get("is_linked");
            boolean is_sold = (boolean)result.get("is_sold");*/

            return new Card(cardID, opalCardNumber, cardType, cardBalance, cardStatus,userEmail);
        }
        return null;
    }

    public Card[] getCards(String userEmail){

        //BasicDBObject allQuery = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        fields.put("userEmail", userEmail);

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
            //String newUserEmail = (String)result.get("userEmail");
            //boolean is_linked = result.get("is_linked").toString();
            //boolean is_sold = (boolean)result.get("is_sold");
            card[count] = new Card(cardID, opalCardNumber, cardType, cardBalance, cardStatus,userEmail);
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

            //int newCardID = (int)result.get("cardID");
            String opalCardNumber = (String)result.get("opalCardNumber");
            String cardType = (String)result.get("cardType");
            double cardBalance = (double)result.get("cardBalance");
            String cardStatus = (String)result.get("cardStatus");
            String userEmail = (String)result.get("userEmail");
           /* boolean is_linked = (boolean)result.get("is_linked");
            boolean is_sold = (boolean)result.get("is_sold");*/

            double newBalance = 20 + cardBalance;

            //BasicDBObject records = new BasicDBObject();
            BasicDBObject update = new BasicDBObject();
            update.append("cardID", cardID);
            update.append("opalCardNumber", opalCardNumber);
            update.append("cardType", cardType);
            update.append("cardBalance", newBalance);
            update.append("cardStatus", cardStatus);
            update.append("userEmail", userEmail);
            //update.append("is_linked", is_linked);
            //update.append("is_sold", is_sold);
            collection.update(fields, update);

            return new Card(cardID, opalCardNumber, cardType, cardBalance, cardStatus,userEmail);
        }
        return null;
    }

    public void transferBalance(Card[] cards,int selectFirstCard,int selectSecondCard) {

        double fristCardBalance = (double) cards[selectFirstCard].getCardBalance();

        double secondCardBalance = (double) cards[selectSecondCard].getCardBalance();

        BasicDBObject fields2 = new BasicDBObject();
        fields2.put("cardBalance", selectSecondCard);

        DBCursor cursor2 = collection.find(fields2);
        DBObject result2 = cursor2.one();
        while (cursor2.hasNext()) {

            int cardID = (int) result2.get("cardID");
            String opalCardNumber = (String) result2.get("opalCardNumber");
            String cardType = (String) result2.get("cardType");
            //double cardBalance = (double)result.get("cardBalance");
            String cardStatus = (String) result2.get("cardStatus");
            String userEmail = (String) result2.get("userEmail");
           /* boolean is_linked = (boolean)result.get("is_linked");
            boolean is_sold = (boolean)result.get("is_sold");*/

            double newBalance = fristCardBalance + secondCardBalance;

            //BasicDBObject records = new BasicDBObject();
            BasicDBObject update = new BasicDBObject();
            update.append("cardID", cardID);
            update.append("opalCardNumber", opalCardNumber);
            update.append("cardType", cardType);
            update.append("cardBalance", newBalance);
            update.append("cardStatus", cardStatus);
            update.append("userEmail", userEmail);
            //update.append("is_linked", is_linked);
            //update.append("is_sold", is_sold);
            collection.update(fields2, update);
        }
    }
}
