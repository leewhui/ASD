package com.app.asd;

import com.app.asd.Model.*;
import com.app.asd.Utils.dbConnect;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import static com.mongodb.client.model.Filters.eq;

public class R2_staffCardManagement {
    private MongoCollection<Document> collection = null;
    private MongoClient mongoClient = null;
    private MongoDatabase db = null;

    @Before
    public void start() {
        mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://wenhuili:lwh971213@cluster0.bgi8l.mongodb.net/ASD?retryWrites=true&w=majority"));
        db = mongoClient.getDatabase("ASD");
        collection = dbConnect.getMongoCollection("User");
    }

    @Test
    public void testGetCollection() throws Exception {
        collection = dbConnect.getMongoCollection("Card");
    }

    @Test
    public void cardOwnerUpdate() {
        Bson filter = eq("_id", new ObjectId("5f485c31465e7b819cff178f"));
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("userEmail", "uts@gmail.com");
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);
        dbConnect.updateOne("Card", filter, updateObject);
    }
}
