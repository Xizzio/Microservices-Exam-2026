package com.microservices.notification.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @RabbitListener(queues = "notificationQueue")
    public void handleNotification(String notificationMessage) {

        // implement database save logic here for notification next
        

        System.out.println("Notification received: " + notificationMessage);
    }
}