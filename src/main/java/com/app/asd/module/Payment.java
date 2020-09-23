package com.app.asd.module;

public class Payment {
    private int paymentID;
    private int creditCardNumber;
    private String paymentType;
    private double paymentBalance;
    private String paymentStatus;
    private String paymentDate;
    private String gender;
    private String billingAddress;
    private int userID;

    public Payment(int paymentID, int creditCardNumber, String paymentType, double paymentBalance, String paymentStatus, String paymentDate, String gender, String billingAddress, int userID) {
        this.paymentID = paymentID;
        this.creditCardNumber = creditCardNumber;
        this.paymentType = paymentType;
        this.paymentBalance = paymentBalance;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.gender = gender;
        this.billingAddress = billingAddress;
        this.userID = userID;
    }

    public Payment(int paymentID) {
        this.paymentID = paymentID;
    }

    public Payment(double paymentBalance) {
        this.paymentBalance = paymentBalance;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getPaymentBalance() {
        return paymentBalance;
    }

    public void setPaymentBalance(double paymentBalance) {
        this.paymentBalance = paymentBalance;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", creditCardNumber=" + creditCardNumber +
                ", paymentType='" + paymentType + '\'' +
                ", paymentBalance=" + paymentBalance +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", gender='" + gender + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", userID=" + userID +
                '}';
    }
}
