package com.app.asd.Utils;
import com.app.asd.module.*;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class dbConnect
{
    private static MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://zhilingwang:123321@cluster0.bgi8l.mongodb.net/ASD?retryWrites=true&w=majority"));
    private static MongoDatabase db = mongoClient.getDatabase("ASD");
    private static Gson gson = new Gson();

    private dbConnect() {}

    public static void main(String[] args)
    {
        try {
            MongoCollection<Document> collection = getMongoCollection("Card");
            BasicDBObject obj = new BasicDBObject("userID","12345678");
            MongoCursor<Document> cursor = queryCursor("Card", obj);

            while (cursor.hasNext()) {
                Card card = gson.fromJson(cursor.next().toJson(), Card.class);
                System.out.println(card);
                System.out.println(card.getCardStatus());
            }
            Document document = new Document("title", "MongoDB");
            insertOneDocument("Card", document);

        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    public static MongoCollection<Document> getMongoCollection(String collectionName)
    {
        return db.getCollection(collectionName);
    }

    public static MongoCursor<Document> queryCursor(String collectionName, BasicDBObject queryObj)
    {
        MongoCollection<Document> collection = getMongoCollection(collectionName);
        FindIterable<Document> fi = collection.find(queryObj);
        return fi.iterator();
    }

    public static String insertOneDocument(String collectionName, Document document)
    {
        try {
            MongoCollection<Document> collection = getMongoCollection(collectionName);
            collection.insertOne(document);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static MongoCursor<Document> findAll(String collName){
        MongoCollection<Document> coll = db.getCollection(collName);
        List<Document> result = new ArrayList<Document>();
        FindIterable<Document> findIterable = coll.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        return mongoCursor;

    }

}
