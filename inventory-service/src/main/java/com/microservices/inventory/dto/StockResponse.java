package com.microservices.inventory.dto;

public class StockResponse {
    private boolean success;
    private String message;
    private String productName;
    private int requestedQuantity;
    private int remainingStock;

    public StockResponse(boolean success, String message, String productName, int requestedQuantity, int remainingStock) {
        this.success = success;
        this.message = message;
        this.productName = productName;
        this.requestedQuantity = requestedQuantity;
        this.remainingStock = remainingStock;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getProductName() {
        return productName;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public int getRemainingStock() {
        return remainingStock;
    }
}