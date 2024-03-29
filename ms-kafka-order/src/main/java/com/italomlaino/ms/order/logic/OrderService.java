package com.italomlaino.ms.order.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

	private OrderRepository orderRepository;

	private KafkaTemplate<String, Order> kafkaTemplate;

	@Autowired
	private OrderService(OrderRepository orderRepository, @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") KafkaTemplate<String, Order> kafkaTemplate) {
		this.orderRepository = orderRepository;
		this.kafkaTemplate = kafkaTemplate;
	}

	public Order order(Order order) {
		if (order.getNumberOfLines() == 0) {
			throw new IllegalArgumentException("No order lines!");
		}

		order.setUpdated(new Date());

		Order result = orderRepository.save(order);
		fireOrderCreatedEvent(order);

		return result;
	}

	private void fireOrderCreatedEvent(Order order) {
		kafkaTemplate.send("order", order.getId() + "created", order);
	}
}
