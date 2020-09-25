package com.app.asd.Utils.DAO;

//import com.app.asd.module.Payment;
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

    public Payment getInvoice(int userID){

        BasicDBObject allQuery = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        fields.put("paymentID", userID);

        DBCursor cursor = collection.find(fields);
        DBObject result = cursor.one();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
            double paymentResult = (double)result.get("paymentBalance");

            int newPaymentID = (int)result.get("paymentID");
            int creditCardNumber = (int)result.get("creditCardNumber");
            String paymentType = (String)result.get("paymentType");
            double paymentBalance = (double)result.get("paymentBalance");
            String paymentStatus = (String)result.get("paymentStatus");
            String paymentDate = (String)result.get("paymentDate");
            String gender = (String)result.get("gender");
            String billingAddress = (String)result.get("billingAddress");
            int newUserID = (int)result.get("userID");


            return new Payment(newPaymentID,creditCardNumber,paymentType,paymentBalance,paymentStatus,paymentDate,gender,billingAddress,newUserID);
        }
        return null;
    }
}
