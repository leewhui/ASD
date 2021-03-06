package com.app.asd.Utils;
import com.app.asd.Model.User;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

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
    
    //update user information
    public static String updateOneUser(User user)
    {
        try {
            MongoCollection<Document> collection = getMongoCollection("User");
            // update one document
            Bson filter = eq("username", user.getUsername());
            Bson updateOperation = combine(set("first_name", user.getFirst_name()),
                    set("last_name", user.getLast_name()),
                    set("password", user.getPassword()),
                    set("gender", user.getGender()),
                    set("dob", user.getDob()),
                    set("card_number", user.getCardNumber())
            );
            collection.updateOne(filter, updateOperation);//update
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    // Find all documents in MongoDB which meet the queryObj and use iterator to pass document one by one
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

    // Find all documents from one collection in MongoDB
    public static MongoCursor<Document> findAll(String collName){
        MongoCollection<Document> coll = db.getCollection(collName);
        List<Document> result = new ArrayList<Document>();
        FindIterable<Document> findIterable = coll.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        return mongoCursor;

    }
    // Update one document in one collection in MongoDB
    public static UpdateResult updateOne(String collName, Bson filter, Bson update) {
        MongoCollection<Document> coll = db.getCollection(collName);
        UpdateResult result = coll.updateOne(filter, update);

        return result;
    }
    // Delete one document in one collection in MongoDB
    public static void deleteOne(String collName, Bson document) {
        MongoCollection<Document> coll = db.getCollection(collName);
        coll.deleteOne(document);
    }

    public static DeleteResult removeOne(String collectionName, Bson bson)
    {
        MongoCollection<Document> collection = dbConnect.getMongoCollection(collectionName);
        return collection.deleteOne(bson);
    }

    public static DeleteResult removeMany(String collectionName, Bson bson)
    {
        MongoCollection<Document> collection = dbConnect.getMongoCollection(collectionName);
        return collection.deleteMany(bson);
    }

}
