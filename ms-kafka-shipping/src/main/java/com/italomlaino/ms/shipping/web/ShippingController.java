package com.italomlaino.ms.shipping.web;

import com.italomlaino.ms.shipping.Shipment;
import com.italomlaino.ms.shipping.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {

	private ShipmentRepository shipmentRepository;

	@Autowired
	public ShippingController(ShipmentRepository shipmentRepository) {
		this.shipmentRepository = shipmentRepository;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Shipment Item(@PathVariable("id") long id) {
		return shipmentRepository.findById(id).get();
	}

	@RequestMapping("/")
	public Iterable<Shipment> ItemList() {
		return shipmentRepository.findAll();
	}
}
