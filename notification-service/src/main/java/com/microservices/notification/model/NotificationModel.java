package com.microservices.notification.model;

public class NotificationModel {
    private String id;
    private String message;
    private String recipient;

    public NotificationModel() {
    }

    public NotificationModel(String id, String message, String recipient) {
        this.id = id;
        this.message = message;
        this.recipient = recipient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}