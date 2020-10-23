package com.app.asd.Utils.DAO;
import com.app.asd.Model.Payment;
import com.mongodb.*;

public class PaymentDAO {
    MongoClient mongoClient;
    DB database;
    DBCollection collection;

    public PaymentDAO(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        database = mongoClient.getDB("ASD");
        collection = database.getCollection("Payment");
    }

    public void setDatabase(DB database) {
        this.database = database;
    }

    public void addPaymentInfo(String cardName, String creditCardNumber,String validDate, String CVV, String userEmail){

        BasicDBObject newPaymentInfo = new BasicDBObject();
        newPaymentInfo.put("cardName", cardName);
        newPaymentInfo.put("creditCardNumber", creditCardNumber);
        newPaymentInfo.put("validDate", validDate);
        newPaymentInfo.put("CVV", CVV);
        newPaymentInfo.put("userEmail", userEmail);
        collection.insert(newPaymentInfo);
    }

    public void deletePaymentInfo(String userEmail){

        BasicDBObject query = new BasicDBObject();
        query.put("userEmail", userEmail);
        collection.remove(query);
    }


    public Payment getPaymentInfo(String userEmail){

        BasicDBObject fields = new BasicDBObject();
        fields.put("userEmail", userEmail);

        DBCursor cursor = collection.find(fields);
        DBObject result = cursor.one();
        while (cursor.hasNext()) {

             String cardName = (String)result.get("cardName");
             String creditCardNumber = (String)result.get("creditCardNumber");
             String validDate = (String)result.get("validDate");
             String CVV = (String)result.get("CVV");

            return new Payment(cardName, creditCardNumber, validDate, CVV,userEmail);
        }
        return null;
    }

}
