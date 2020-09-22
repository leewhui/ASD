package com.app.asd.module;

import org.bson.types.ObjectId;

public class User {
    private ObjectId userId;
    private String password;
    private String first_name;
    private String last_name;
    private boolean is_staff;
    private String phone;
    private String email;
    private String gender;
    private String dob;
    private String date_registered;
    private boolean activated_status;
    private String username;

    public User(ObjectId userID, String password, String firstName, String lastName, boolean is_staff, String phone, String email, String gender, String dob, String date_registered, boolean activated_status, String username) {
        this.userId = userID;
        this.password = password;
        this.first_name = firstName;
        this.last_name = lastName;
        this.is_staff = is_staff;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.date_registered = date_registered;
        this.activated_status = activated_status;
        this.username = username;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isIs_staff() {
        return is_staff;
    }

    public void setIs_staff(boolean is_staff) {
        this.is_staff = is_staff;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDate_registered() {
        return date_registered;
    }

    public void setDate_registered(String date_registered) {
        this.date_registered = date_registered;
    }

    public boolean getActivated_status() {
        return activated_status;
    }

    public void setActivated_status(boolean activated_status) {
        this.activated_status = activated_status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", is_staff=" + is_staff +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", date_registered='" + date_registered + '\'' +
                ", activated_status='" + activated_status + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}