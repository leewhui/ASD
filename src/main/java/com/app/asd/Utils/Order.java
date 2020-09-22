package com.app.asd.Utils;

public class Order {
    private String orderID;
    private String userEmail;
    private String orderDate;
    private String orderStatus;
    private String orderCardType;
    private String deliveryAddress;
    private String deliveryPostcode;
    private String orderComment;

    public Order(String orderID, String userEmail, String orderDate, String orderStatus, String orderCardType, String deliveryAddress, String deliveryPostcode, String orderComment) {
        this.orderID = orderID;
        this.userEmail = userEmail;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderCardType = orderCardType;
        this.deliveryAddress = deliveryAddress;
        this.deliveryPostcode = deliveryPostcode;
        this.orderComment = orderComment;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderCardType() {
        return orderCardType;
    }

    public void setOrderCardType(String orderCardType) {
        this.orderCardType = orderCardType;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDeliveryPostcode(String deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }
}
