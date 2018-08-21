package com.example.web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vitalii on 20.08.18.
 */
@RestController
@RequestMapping("api")
public class MessageController {

	private final RabbitTemplate rabbitTemplate;
	private final String queueName;

	@Autowired
	public MessageController(RabbitTemplate rabbitTemplate, @Value("${rocket.rabbitmq.queue}") String queueName) {
		this.rabbitTemplate = rabbitTemplate;
		this.queueName = queueName;
	}

	@GetMapping("message")
	public ResponseEntity<String> getAllCustomer() {
		String response = "no message";
		Object message = rabbitTemplate.receiveAndConvert(queueName);
		if (message != null) {
			response = (String) message;
			System.out.println("  received message [" + response.toString() + "] ");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}