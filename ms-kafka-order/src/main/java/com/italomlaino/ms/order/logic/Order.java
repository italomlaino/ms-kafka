package com.italomlaino.ms.order.logic;

import com.italomlaino.ms.order.customer.Customer;
import com.italomlaino.ms.order.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERTABLE")
public class Order {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Customer customer;

	private Date updated;

	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "SHIPPING_STREET")),
			@AttributeOverride(name = "zip", column = @Column(name = "SHIPPING_ZIP")),
			@AttributeOverride(name = "city", column = @Column(name = "SHIPPING_CITY"))})
	private Address shippingAddress = new Address();

	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
			@AttributeOverride(name = "zip", column = @Column(name = "BILLING_ZIP")),
			@AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY"))})
	private Address billingAddress = new Address();

	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLine> orderLine;

	public Order() {
		orderLine = new ArrayList<>();
		updated();
	}

	private void updated() {
		updated = new Date();
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		updated();
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		updated();
		this.billingAddress = billingAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date created) {
		this.updated = created;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		updated();
	}

	public List<OrderLine> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
		updated();
	}

	public void addLine(int count, Item item) {
		this.orderLine.add(new OrderLine(count, item));
		updated();
	}

	public int getNumberOfLines() {
		return orderLine.size();
	}

	public double totalPrice() {
		return orderLine.stream().map((ol) -> ol.getCount() * ol.getItem().getPrice()).reduce(0.0, Double::sum);
	}
}
