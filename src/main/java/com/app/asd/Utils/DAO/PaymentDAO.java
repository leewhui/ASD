package com.app.asd.Utils.DAO;

//import com.app.asd.module.Payment;
import com.app.asd.module.Payment;
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

    public Payment getPaymentBalance(int paymentID){

        BasicDBObject allQuery = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        fields.put("paymentID", paymentID);

        DBCursor cursor = collection.find(fields);
        DBObject result = cursor.one();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
            double paymentResult = (double)result.get("paymentBalance");

            return new Payment(paymentResult);
        }
        return null;
    }
}
