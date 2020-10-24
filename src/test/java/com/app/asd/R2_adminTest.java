package com.app.asd;

import com.app.asd.Model.*;
import com.app.asd.Utils.dbConnect;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

public class R2_adminTest {
    private MongoCollection<Document> collection = null;
    private MongoCollection<Document> collectionC = null;
    private MongoClient mongoClient = null;
    private MongoDatabase db = null;

    @Before
    public void start()
    {
        mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://wenhuili:lwh971213@cluster0.bgi8l.mongodb.net/ASD?retryWrites=true&w=majority"));
        db = mongoClient.getDatabase("ASD");
        collection = dbConnect.getMongoCollection("User");
        collectionC = dbConnect.getMongoCollection("Card");
    }

    @Test
    public void testGetUserAndCard() throws Exception
    {
        collection = dbConnect.getMongoCollection("User");
        collectionC = dbConnect.getMongoCollection("Card");
    }

    @Test
    public void testInsertAdmin()
    {
        Document document = new Document("username", "junitAdminTest");
        dbConnect.insertOneDocument("User", document);
    }

    @Test
    public void testFindAll(){
        dbConnect.findAll("Card");
        dbConnect.findAll("User");
    }
}
