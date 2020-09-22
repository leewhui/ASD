package com.app.asd.Model.dao;

import com.app.asd.Model.*;
import com.mongodb.*;
import org.bson.types.ObjectId;


public class adminHomeDao {

    MongoClient mongoClient;
    DB database;
    DBCollection collection;

    public adminHomeDao(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        database = mongoClient.getDB("ASD");
        collection = database.getCollection("User");
    }

    public void setDatabase(DB database) {
        this.database = database;
    }

    public User[] getAllUser() {

        DBCursor cursor = collection.find();
        User[] user = new User[cursor.count()];
        int count = 0;
        while (cursor.hasNext()) {
            DBObject result = cursor.next();

            ObjectId userID;
            String password = "null";
            String firstName = "null";
            String lastName = "null";
            boolean is_staff = false;
            String phone = "null";
            String email = "null";
            String gender = "null";
            String dob = "null";
            String date_registered = "null";
            boolean activated_status = false;
            String username = "null";


            userID = (ObjectId) result.get("_id");

            if ((String) result.get("password") != null) {
                password = (String) result.get("password");
            }

            if ((String) result.get("first_name") != null) {
                firstName = (String) result.get("first_name");
            }

            if ((String) result.get("last_name") != null) {
                lastName = (String) result.get("last_name");
            }

            try {
                is_staff = (boolean) result.get("is_staff");
            } catch (Exception e) {
            }
            ;

//            if((boolean)result.get("is_staff") != null){
//            is_staff = (boolean)result.get("is_staff");}

            if ((String) result.get("phone") != null) {
                phone = (String) result.get("phone");
            }

            if ((String) result.get("email") != null) {
                email = (String) result.get("email");
            }

            if ((String) result.get("gender") != null) {
                gender = (String) result.get("gender");
            }

            if ((String) result.get("dob") != null) {
                dob = (String) result.get("dob");
            }

            if ((String) result.get("date_registered") != null) {
                date_registered = (String) result.get("date_registered");
            }

            try {
                activated_status = (boolean) result.get("activated_status");
            } catch (Exception e) {
            }
            ;

//            if((boolean)result.get("activated_status") != null){
//            activated_status = (boolean)result.get("activated_status");}

            if ((String) result.get("username") != null) {
                username = (String) result.get("username");
            }

            user[count] = new User(userID, password, firstName, lastName, is_staff, phone, email, gender, dob, date_registered, activated_status, username);
            count++;

        }
        return user;
    }


    public User getSearch(String userEmail) {


        BasicDBObject query = new BasicDBObject();
        query.put("email", userEmail);
        DBCursor cursor = collection.find(query);
        DBObject result = cursor.one();
        if (result != null) {
            ObjectId userID;
            String password = "null";
            String firstName = "null";
            String lastName = "null";
            boolean is_staff = false;
            String phone = "null";
            String email = "null";
            String gender = "null";
            String dob = "null";
            String date_registered = "null";
            boolean activated_status = false;
            String username = "null";

            userID = (ObjectId) result.get("_id");

            if ((String) result.get("password") != null) {
                password = (String) result.get("password");
            }

            if ((String) result.get("first_name") != null) {
                firstName = (String) result.get("first_name");
            }

            if ((String) result.get("last_name") != null) {
                lastName = (String) result.get("last_name");
            }

            try {
                is_staff = (boolean) result.get("is_staff");
            } catch (Exception e) {
            }
            ;

            if ((String) result.get("phone") != null) {
                phone = (String) result.get("phone");
            }

            if ((String) result.get("email") != null) {
                email = (String) result.get("email");
            }

            if ((String) result.get("gender") != null) {
                gender = (String) result.get("gender");
            }

            if ((String) result.get("dob") != null) {
                dob = (String) result.get("dob");
            }

            if ((String) result.get("date_registered") != null) {
                date_registered = (String) result.get("date_registered");
            }

            try {
                activated_status = (boolean) result.get("activated_status");
            } catch (Exception e) {
            }
            ;

//            if((boolean)result.get("activated_status") != null){
//            activated_status = (boolean)result.get("activated_status");}

            if ((String) result.get("username") != null) {
                username = (String) result.get("username");
            }


            User finded = new User(userID, password, firstName, lastName, is_staff, phone, email, gender, dob, date_registered, activated_status, username);

            return finded;

        }

        return null;
    }

    public void editUser(String userID, String password, String firstname, String lastname, String is_staff, String phone, String email, String gender, String dob, String date, String act, String username) {

        ObjectId id;
        id = new ObjectId(userID);
        boolean iss;
        boolean bact;

        if (is_staff.equals("YES")) {
            iss = true;
        } else {
            iss = false;
        }
        if (act.equals("YES")) {
            bact = true;
        } else {
            bact = false;
        }

        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);
        BasicDBObject newRecord = new BasicDBObject();
        newRecord.put("password", password);
        newRecord.put("first_name", firstname);
        newRecord.put("last_name", lastname);
        newRecord.put("is_staff", iss);
        newRecord.put("phone", phone);
        newRecord.put("email", email);
        newRecord.put("gender", gender);
        newRecord.put("dob", dob);
        newRecord.put("date_registered", date);
        newRecord.put("activated_status", bact);
        newRecord.put("username", username);
        collection.update(query, newRecord);


    }


}
