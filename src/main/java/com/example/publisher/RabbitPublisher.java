package com.example.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Vitalii on 21.08.18.
 */
@Component
public class RabbitPublisher {

	private final AmqpTemplate amqpTemplate;
	private final String exchange;
	private final String routingKey;

	@Autowired
	public RabbitPublisher(AmqpTemplate amqpTemplate,
						   @Value("${rocket.rabbitmq.exchange}") String exchange,
						   @Value("${rocket.rabbitmq.routingkey}") String routingKey) {
		this.amqpTemplate = amqpTemplate;
		this.exchange = exchange;
		this.routingKey = routingKey;
	}

	public void produceMsg(String msg) {
		amqpTemplate.convertAndSend(exchange, routingKey, msg);
		System.out.println("Send msg = " + msg);
	}
}