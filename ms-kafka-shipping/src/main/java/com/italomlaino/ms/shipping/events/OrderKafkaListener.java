package com.italomlaino.ms.shipping.events;

import com.italomlaino.ms.shipping.Shipment;
import com.italomlaino.ms.shipping.ShipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class OrderKafkaListener {

	private final Logger log = LoggerFactory.getLogger(OrderKafkaListener.class);

	private ShipmentService shipmentService;

	public OrderKafkaListener(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}

	@KafkaListener(topics = "order")
	public void order(Shipment shipment, Acknowledgment acknowledgment) {
		log.info("Received shipment " + shipment.getId());
		shipmentService.ship(shipment);
		acknowledgment.acknowledge();
	}

}
