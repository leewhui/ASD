package com.app.asd.Utils;
import com.app.asd.module.User;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.util.JSON;
import org.bson.Document;

public class dbConnect
{
    private static MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://wenhuili:lwh971213@cluster0.bgi8l.mongodb.net/ASD?retryWrites=true&w=majority"));
    private static MongoDatabase db = mongoClient.getDatabase("ASD");
    private static Gson gson = new Gson();

    private dbConnect() {}

    public static void main(String[] args)
    {
        try {
            MongoCollection<Document> collection = getMongoCollection("User");
            BasicDBObject obj = new BasicDBObject("first_name","wenhui");
            MongoCursor<Document> cursor = queryCursor("User", obj);

            while (cursor.hasNext()) {
                User user = gson.fromJson(cursor.next().toJson(), User.class);
                System.out.println(user);
                System.out.println(user.getEmail());
            }
            Document document = new Document("title", "MongoDB");
            insertOneDocument("User", document);

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

}