package com.app.asd.Utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import java.net.UnknownHostException;


public class JGDBC {

    MongoClient mongoClient;

    public MongoDatabase getMongoDB() {
        return mongoClient.getDatabase("ASD");
    }

    public JGDBC() throws UnknownHostException {
        String dbUri = String.format("mongodb+srv://wenhuili:lwh971213@cluster0.bgi8l.mongodb.net/ASD?retryWrites=true&w=majority");
        mongoClient = new MongoClient(new MongoClientURI(dbUri));
    }

    public MongoClient openConnection() {
        return this.mongoClient;
    }

    public void closeConnection() {
        mongoClient.close();
    }

}
