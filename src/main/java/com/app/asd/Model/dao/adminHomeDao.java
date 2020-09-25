package com.app.asd.Model.dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;
import java.io.IOException;
import java.util.ArrayList;

import com.app.asd.Utils.dbConnect;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.app.asd.Model.*;


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
                boolean tempAct = (boolean)result.get("activated_status");

                if(tempAct)
                { activated_status = "YES";}
                else
                { activated_status = "NO";}
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


    public User getSearch(String email) {


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
                boolean tempAct = (boolean)result.get("activated_status");

                if(tempAct)
                    { activated_status = "YES";}
                else
                    { activated_status = "NO";}
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

    public void editUser(String password, String firstname, String lastname, String is_staff, String phone, String email, String gender, String dob, String date, String act, String username) {


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
        query.put("email", email);
        BasicDBObject newRecord = new BasicDBObject();
        newRecord.put("email",email);
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
        collection.update(query, newRecord);


    }


}
