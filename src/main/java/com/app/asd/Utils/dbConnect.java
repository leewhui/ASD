package com.app.asd.Utils;
import com.app.asd.Model.User;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Updates.*;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class dbConnect
{
    private static MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://wenhuili:lwh971213@cluster0.bgi8l.mongodb.net/ASD?retryWrites=true&w=majority"));
    private static MongoDatabase db = mongoClient.getDatabase("ASD");
    private static Gson gson = new Gson();

    private dbConnect() {}

    public static void main(String[] args)
    {
        try {
//            MongoCollection<Document> collection = getMongoCollection("User");
//            BasicDBObject obj = new BasicDBObject("first_name","wenhui");
//            MongoCursor<Document> cursor = queryCursor("User", obj);
//
//            while (cursor.hasNext()) {
//                User user = gson.fromJson(cursor.next().toJson(), User.class);
//                System.out.println(user);
//                System.out.println(user.getEmail());
//            }
//            Document document = new Document("title", "MongoDB");
//            insertOneDocument("User", document);
            Bson filter = eq("first_name", "Wenhui_update");
            Bson updateOperation = set("first_name", "wenhui");
            dbConnect.update("User", filter, updateOperation);

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

//    public static FindIterable<Document> queryCursor(String collectionName, BasicDBObject queryObj)
//    {
//        MongoCollection<Document> collection = getMongoCollection(collectionName);
//        FindIterable<Document> fi = collection.find(queryObj);
//        return fi;
//    }

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

    public static UpdateResult update(String collectionName, Bson filter, Bson updateOperation)
    {
        MongoCollection<Document> collection = dbConnect.getMongoCollection(collectionName);
        UpdateResult updateResult = collection.updateOne(filter, updateOperation);
        System.out.println(updateResult);
        return updateResult;
    }

}
