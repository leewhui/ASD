package com.app.asd.Model;

public class Card {


    private int cardId;
    private int cardNum;
    private String cardType;
    private double cardBalance;
    private String cardStatus;
    private int userId;
    private boolean isLinked;
    private boolean isSold;

    public Card(int cardId, int cardNum, String cardType, double cardBalance, String cardStatus, int userId, boolean isLinked, boolean isSold) {
        this.cardId = cardId;
        this.cardNum = cardNum;
        this.cardType = cardType;
        this.cardBalance = cardBalance;
        this.cardStatus = cardStatus;
        this.userId = userId;
        this.isLinked = isLinked;
        this.isSold = isSold;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isLinked() {
        return isLinked;
    }

    public void setLinked(boolean linked) {
        isLinked = linked;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
