package com.fakegram.microservices.auth.kafkalisteners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerPostCounter {
	@KafkaListener(topics = "counterPosts", groupId="groupId")
	void listener(String data) {
		System.out.println("Listner recived: " + data);
	}
}
