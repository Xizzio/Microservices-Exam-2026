package com.microservices.inventory.dto;

public class DecreaseStockRequest {
    private String productName;
    private int quantity;

    public DecreaseStockRequest() {}

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
}