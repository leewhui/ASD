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

        BasicDBObject fields = new BasicDBObject();
        fields.put("cardID", cardID);

        DBCursor cursor = collection.find(fields);
        DBObject result = cursor.one();
        while (cursor.hasNext()) {

            String opalCardNumber = (String)result.get("opalCardNumber");
            String cardType = (String)result.get("cardType");
            double cardBalance = (double)result.get("cardBalance");
            String cardStatus = (String)result.get("cardStatus");
            String userEmail = (String)result.get("userEmail");


            return new Card(cardID, opalCardNumber, cardType, cardBalance, cardStatus,userEmail);
        }
        return null;
    }

    public Card[] getCards(String userEmail){

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

            card[count] = new Card(cardID, opalCardNumber, cardType, cardBalance, cardStatus,userEmail);
            count++;
        }
        return card;
    }

    public Card updateBalance(int cardID,double money){

        BasicDBObject fields = new BasicDBObject();
        fields.put("cardID", cardID);

        DBCursor cursor = collection.find(fields);
        DBObject result = cursor.one();
        while (cursor.hasNext()) {

            String opalCardNumber = (String)result.get("opalCardNumber");
            String cardType = (String)result.get("cardType");
            double cardBalance = (double)result.get("cardBalance");
            String cardStatus = (String)result.get("cardStatus");
            String userEmail = (String)result.get("userEmail");


            double newBalance = money + cardBalance;

            BasicDBObject update = new BasicDBObject();
            update.append("cardID", cardID);
            update.append("opalCardNumber", opalCardNumber);
            update.append("cardType", cardType);
            update.append("cardBalance", newBalance);
            update.append("cardStatus", cardStatus);
            update.append("userEmail", userEmail);
            collection.update(fields, update);

            return new Card(cardID, opalCardNumber, cardType, cardBalance, cardStatus,userEmail);
        }
        return null;
    }

    public Card transferBalance(int firstID,int secondID) {

        BasicDBObject fields = new BasicDBObject();
        fields.put("cardID", secondID);

        DBCursor cursor= collection.find(fields);
        DBObject result = cursor.one();

        BasicDBObject fields2 = new BasicDBObject();
        fields2.put("cardID", firstID);

        DBCursor cursor2 = collection.find(fields2);
        DBObject result2 = cursor2.one();

        double secondCardBalance = (double)result.get("cardBalance");
        double firstCardBalance = (double)result2.get("cardBalance");
        double newBalance = secondCardBalance + firstCardBalance;

        while (cursor.hasNext() && cursor2.hasNext()) {

            int cardID = (int) result.get("cardID");
            String opalCardNumber = (String) result.get("opalCardNumber");
            String cardType = (String) result.get("cardType");

            String cardStatus = (String) result.get("cardStatus");
            String userEmail = (String) result.get("userEmail");

            int cardID2 = (int) result2.get("cardID");
            String opalCardNumber2 = (String) result2.get("opalCardNumber");
            String cardType2 = (String) result2.get("cardType");
            double balance2 = 0;
            String cardStatus2 = (String) result2.get("cardStatus");
            String userEmail2 = (String) result2.get("userEmail");

            BasicDBObject update2 = new BasicDBObject();
            update2.append("cardID", cardID2);
            update2.append("opalCardNumber", opalCardNumber2);
            update2.append("cardType", cardType2);
            update2.append("cardBalance", balance2);
            update2.append("cardStatus", cardStatus2);
            update2.append("userEmail", userEmail2);

            collection.update(fields2, update2);

            BasicDBObject update = new BasicDBObject();
            update.append("cardID", cardID);
            update.append("opalCardNumber", opalCardNumber);
            update.append("cardType", cardType);
            update.append("cardBalance", newBalance);
            update.append("cardStatus", cardStatus);
            update.append("userEmail", userEmail);

            collection.update(fields, update);

            return new Card(cardID, opalCardNumber, cardType, newBalance, cardStatus,userEmail);
        }
        return null;
    }
}
