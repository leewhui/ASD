package com.app.asd.module;

public class Card {
    private int cardID;
    private String opalCardNumber;
    private String cardType;
    private double cardBalance;
    private String cardStatus;
    private int userID;
    private boolean is_linked;
    private boolean is_sold;

    public Card(int cardID, int userID) {
        this.cardID = cardID;
        this.userID = userID;
    }

    public Card(int cardID, String opalCardNumber, String cardType, double cardBalance, String cardStatus, int userID) {
        this.cardID = cardID;
        this.opalCardNumber = opalCardNumber;
        this.cardType = cardType;
        this.cardBalance = cardBalance;
        this.cardStatus = cardStatus;
        this.userID = userID;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

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

    @Override
    public String toString() {
        return "Card{" +
                "cardID=" + cardID +
                "opalCardNumber=" + opalCardNumber +
                ", cardType=" + cardType +
                ", cardBalance='" + cardBalance + '\'' +
                ", cardStatus=" + cardStatus + '\'' +
                ", userID=" + userID + '\'' +
                ", is_linked='" + is_linked + '\'' +
                ", is_sold='" + is_sold + '\'' +
                '}';
    }
}
