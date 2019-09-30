package com.italomlaino.ms.shipping;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Shipment {

	@Id
	private long id;

	@Embedded
	private Customer customer;

	private Date updated;

	@Embedded
	private Address shippingAddress = new Address();

	@OneToMany(cascade = CascadeType.ALL)
	private List<ShipmentLine> shipmentLine;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customerId) {
		this.customer = customerId;
	}


	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date created) {
		this.updated = created;
	}

	@Transient
	public void setOrderLine(List<ShipmentLine> orderLine) {
		this.shipmentLine = orderLine;
	}

	public int getNumberOfLines() {
		return shipmentLine.size();
	}

	public List<ShipmentLine> getShipmentLine() {
		return shipmentLine;
	}

	public void setShipmentLine(List<ShipmentLine> shipmentLine) {
		this.shipmentLine = shipmentLine;
	}
}
