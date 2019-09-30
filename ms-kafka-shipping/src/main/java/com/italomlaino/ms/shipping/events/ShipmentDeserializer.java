package com.italomlaino.ms.shipping.events;

import com.italomlaino.ms.shipping.Shipment;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class ShipmentDeserializer extends JsonDeserializer<Shipment> {

	public ShipmentDeserializer() {
		super(Shipment.class);
	}

}
