package com.notificationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
	
	  @KafkaListener(topics = "notificationTopic")
	    public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
	      System.out.println("NOTIFICATION : Order placed successfully and order number is "+orderPlacedEvent.getOrderNumber());
	        // send out an email notification
	    }

}
