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

public class R2_orderTest {
    private MongoCollection<Document> collection = null;
    private MongoClient mongoClient = null;
    private MongoDatabase db = null;

    @Before
    public void start()
    {
        mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://wenhuili:lwh971213@cluster0.bgi8l.mongodb.net/ASD?retryWrites=true&w=majority"));
        db = mongoClient.getDatabase("ASD");
        collection = dbConnect.getMongoCollection("Order");
    }

    @Test
    public void testGetCollection() throws Exception
    {
        collection = dbConnect.getMongoCollection("Order");
    }

    @Test
    public void testDeleteOrder()
    {
        Document delete = new Document();
        delete.append("orderID", "100001");

        dbConnect.deleteOne("Order", delete);
    }

}
