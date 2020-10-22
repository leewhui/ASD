package com.app.asd.Model;

import org.bson.types.ObjectId;

public class Card {
    private ObjectId _id;
    private String ID;
    private int cardID;
    private String opalCardNumber;
    private String cardType;
    private double cardBalance;
    private String cardStatus;
    private String userEmail;
    private boolean is_linked;
    private boolean is_sold;

    public Card(int cardID, String opalCardNumber, String cardType, double cardBalance, String cardStatus, String userEmail, boolean is_linked, boolean is_sold) {
        this.cardID = cardID;
        this.opalCardNumber = opalCardNumber;
        this.cardType = cardType;
        this.cardBalance = cardBalance;
        this.cardStatus = cardStatus;
        this.userEmail = userEmail;
        this.is_linked = is_linked;
        this.is_sold = is_sold;
    }

    public Card(int cardID, String opalCardNumber, String cardType, double cardBalance, String cardStatus, String userEmail) {
        this.cardID = cardID;
        this.opalCardNumber = opalCardNumber;
        this.cardType = cardType;
        this.cardBalance = cardBalance;
        this.cardStatus = cardStatus;
        this.userEmail = userEmail;
    }
    
    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getOpalCardNumber() {
        return opalCardNumber;
    }

    public void setOpalCardNumber(String opalCardNumber) {
        this.opalCardNumber = opalCardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }


    public boolean isIs_linked() {
        return is_linked;
    }

    public void setIs_linked(boolean is_linked) {
        this.is_linked = is_linked;
    }

    public boolean isIs_sold() {
        return is_sold;
    }

    public void setIs_sold(boolean is_sold) {
        this.is_sold = is_sold;
    }

    /*@Override
    public String toString() {
        return "Card{" +
                "cardID=" + cardID + '\'' +
                "opalCardNumber=" + opalCardNumber + '\'' +
                ", cardType=" + cardType + '\'' +
                ", cardBalance='" + cardBalance + '\'' +
                ", cardStatus=" + cardStatus + '\'' +
                ", userEmail=" + userEmail + '\'' +
                ", is_linked=" + is_linked + '\'' +
                ", is_sold=" + is_sold + '\'' +
                '}';*/
    }


