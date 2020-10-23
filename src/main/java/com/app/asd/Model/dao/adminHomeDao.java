package com.app.asd.Model.dao;

import com.app.asd.Model.Card;
import com.app.asd.Model.User;
import com.mongodb.*;


public class adminHomeDao {

    MongoClient mongoClient;
    DB database;
    DBCollection collection;
    DBCollection collectionCard;

    public adminHomeDao(MongoClient mongoClient, String type) { //build up the object
        this.mongoClient = mongoClient;
        database = mongoClient.getDB("ASD");

        if (type.equals("User")) {// get User collection
            collection = database.getCollection("User");
        } else if (type.equals("Card")) {//get Card collection
            collectionCard = database.getCollection("Card");
        }
    }

    public void setDatabase(DB database) {
        this.database = database;
    }

    public User[] getAllUser() { // this method get all the user information from database, return a array contain all the user

        DBCursor cursor = collection.find();
        User[] users = new User[cursor.count()];
        int count = 0;
        while (cursor.hasNext()) {
            DBObject result = cursor.next();


            String password = "null";
            String firstName = "null";
            String lastName = "null";
            boolean is_staff = false;
            String phone = "null";
            String email = "null";
            String gender = "null";
            String dob = "null";
            String date_registered = "null";
            String activated_status = "null";
            String username = "null";


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
                boolean tempAct = (boolean) result.get("activated_status");
                activated_status = tempAct ? "YES" : "NO";
            } catch (Exception e) {
                activated_status = "NO";
            }


            if ((String) result.get("username") != null) {
                username = (String) result.get("username");
            }

            User newOne = new User();
            newOne.setPassword(password);
            newOne.setFirst_name(firstName);
            newOne.setLast_name(lastName);
            newOne.setIs_staff(is_staff);
            newOne.setPhone(phone);
            newOne.setEmail(email);
            newOne.setGender(gender);
            newOne.setDob(dob);
            newOne.setDate_registered(date_registered);
            newOne.setActivated_status(activated_status);
            newOne.setUsername(username);

            users[count] = newOne;
            count++;


        }
        return users;
    }


    public User getSearch(String email) { // search one user in the database, return a object of the result, if null return null


        BasicDBObject query = new BasicDBObject();
        query.put("email", email);
        DBCursor cursor = collection.find(query);
        DBObject result = cursor.one();
        if (result != null) {
            String password = "null";
            String firstName = "null";
            String lastName = "null";
            boolean is_staff = false;
            String phone = "null";
            String gender = "null";
            String dob = "null";
            String date_registered = "null";
            String activated_status = "null";
            String username = "null";


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
                boolean tempAct = (boolean) result.get("activated_status");

                if (tempAct) {
                    activated_status = "YES";
                } else {
                    activated_status = "NO";
                }
            } catch (Exception e) {
                activated_status = "NO";
            }

            if ((String) result.get("username") != null) {
                username = (String) result.get("username");
            }


            User finded = new User();


            finded.setPassword(password);
            finded.setFirst_name(firstName);
            finded.setLast_name(lastName);
            finded.setIs_staff(is_staff);
            finded.setPhone(phone);
            finded.setEmail(email);
            finded.setGender(gender);
            finded.setDob(dob);
            finded.setDate_registered(date_registered);
            finded.setActivated_status(activated_status);
            finded.setUsername(username);

            return finded;

        }

        return null;
    }

    //edit the user information base the email pass in
    public void editUser(String password, String firstname, String lastname, String is_staff, String phone, String email, String gender, String dob, String date, String act, String username) {


        boolean iss;
        boolean bact;

        iss = is_staff.equals("YES");
        bact = act.equals("YES");

        BasicDBObject query = new BasicDBObject();
        query.put("email", email);
        BasicDBObject newRecord = new BasicDBObject();
        newRecord.put("email", email);
        newRecord.put("password", password);
        newRecord.put("first_name", firstname);
        newRecord.put("last_name", lastname);
        newRecord.put("is_staff", iss);
        newRecord.put("phone", phone);
        newRecord.put("gender", gender);
        newRecord.put("dob", dob);
        newRecord.put("date_registered", date);
        newRecord.put("activated_status", bact);
        newRecord.put("username", username);
        collection.update(query, new BasicDBObject("$set", newRecord));
    }

    public void delUser(String email) {//delete the user base on the email pass in
        BasicDBObject query = new BasicDBObject();
        query.put("email", email);
        collection.remove(query);
    }

    //adding a new user
    public void addUser(String email, String password, String firstname, String lastname, String is_staff, String phone, String gender, String dob, String date, String act, String username) {

        boolean bis_staff = is_staff.equals("YES");
        boolean bact = act.equals("YES");

        BasicDBObject newRecord = new BasicDBObject();
        newRecord.put("email", email);
        newRecord.put("password", password);
        newRecord.put("first_name", firstname);
        newRecord.put("last_name", lastname);
        newRecord.put("is_staff", bis_staff);
        newRecord.put("phone", phone);
        newRecord.put("gender", gender);
        newRecord.put("dob", dob);
        newRecord.put("date_registered", date);
        newRecord.put("activated_status", bact);
        newRecord.put("username", username);

        collection.insert(newRecord);

    }

    //get all the card base on the email, return an array contain all the card object, if null return a array contain null
    public Card[] getAllCard(String email) {
        BasicDBObject query = new BasicDBObject();
        query.put("userEmail", email);
        DBCursor cursor = collectionCard.find(query);
        Card[] cards = new Card[cursor.count()];
        int count = 0;
        while (cursor.hasNext()) {

            DBObject result = cursor.next();

            int cardID = 0;
            String opalCardNumber = "null";
            String cardType = "null";
            double cardBalance = 0.00;
            String cardStatus = "null";
            boolean is_linked = false;
            boolean is_sold = false;


            cardID = (int) result.get("cardID");


            if ((String) result.get("opalCardNumber") != null) {
                opalCardNumber = (String) result.get("opalCardNumber");
            }

            if ((String) result.get("cardType") != null) {
                cardType = (String) result.get("cardType");
            }


            cardBalance = (double) result.get("cardBalance");


            if ((String) result.get("cardStatus") != null) {
                cardStatus = (String) result.get("cardStatus");
            }

            try {
                is_linked = (boolean) result.get("is_linked");
            } catch (Exception e) {
            }
            ;

            try {
                is_sold = (boolean) result.get("is_sold");
            } catch (Exception e) {
            }
            ;

            Card newOne = new Card(cardID, opalCardNumber, cardType, cardBalance, cardStatus, email, is_linked, is_sold);

            cards[count] = newOne;
            count++;
        }
        return cards;

    }

    // edit the card information base on the email pass in
    public void editCard(String opcn, String balance, String cardType, String cardStatus) {
        double dbbalance = Double.parseDouble(balance);

        BasicDBObject query = new BasicDBObject();
        query.put("opalCardNumber", opcn);
        BasicDBObject newRecord = new BasicDBObject();
        newRecord.put("cardBalance", dbbalance);
        newRecord.put("cardType", cardType);
        newRecord.put("cardStatus", cardStatus);
        collectionCard.update(query, new BasicDBObject("$set", newRecord));
    }

}
