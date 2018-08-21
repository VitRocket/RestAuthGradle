package com.example.subscriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Vitalii on 21.08.18.
 */
@Component
public class RabbitSubscriber {

//	@RabbitListener(queues = "${rocket.rabbitmq.queue}")
//	public void recievedMessage(String msg) {
//		System.out.println("Recieved Message: " + msg);
//	}
}
