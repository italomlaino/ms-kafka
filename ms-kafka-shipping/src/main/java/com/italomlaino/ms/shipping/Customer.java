package com.italomlaino.ms.shipping;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Customer {

	@Column(nullable = false)
	private Long customerId;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String firstName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long id) {
		this.customerId = id;
	}
}
