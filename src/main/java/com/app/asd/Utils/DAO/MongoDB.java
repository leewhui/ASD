package com.app.asd.Utils.DAO;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import java.net.UnknownHostException;

public class MongoDB {

    MongoClient mongoClient;

    public MongoDatabase getMongoDB(){
        return mongoClient.getDatabase("ASD");
    }

    public MongoDB() throws UnknownHostException {
        String dbUri = String.format("mongodb+srv://wenhuili:lwh971213@cluster0.bgi8l.mongodb.net/ASD?retryWrites=true&w=majority");
        mongoClient = new MongoClient(new MongoClientURI(dbUri));
    }

    public MongoClient openConnection(){
        return this.mongoClient;
    }

    public void closeConnection() {
        mongoClient.close();
    }
}
