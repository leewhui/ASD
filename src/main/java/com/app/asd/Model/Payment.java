package com.app.asd.Model;

public class Payment {
    private int paymentID;
    private String cardName;
    private String creditCardNumber;
    private String validDate;
    private String CVV;
    private String userEmail;

    public Payment(String cardName, String creditCardNumber, String validDate, String CVV, String userEmail) {
        this.cardName = cardName;
        this.creditCardNumber = creditCardNumber;
        this.validDate = validDate;
        this.CVV = CVV;
        this.userEmail = userEmail;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
