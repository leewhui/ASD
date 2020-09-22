package com.app.asd.module;

import com.app.asd.Utils.dbConnect;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private int staffID;
    private String position;
    private String start_date;
    private int salary;

    public Admin(int staffID, String position, String start_date, int salary) {
        this.staffID = staffID;
        this.position = position;
        this.start_date = start_date;
        this.salary = salary;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void searchUser(int userID) {

    }

    public ArrayList getAllUser() {
        ArrayList<String> userList = new ArrayList<>();
        MongoCollection<Document> dbcollect = dbConnect.getMongoCollection("user");


        return userList;
    }


    public void createUser(Document newone) {
        dbConnect.insertOneDocument("user", newone);
    }


}