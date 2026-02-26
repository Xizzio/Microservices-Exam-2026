package com.microservices.notification.model;

public class NotificationModel {
    private long id;
    private long orderId;
    private long customerId;
    private String orderDate;
    private String productName;
    private int quantity;
    private double totalPrice;

    public NotificationModel() {
    }

    public NotificationModel(long id, long orderId, long customerId, String orderDate, String productName, int quantity, double totalPrice) {
        this.id = id;
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}