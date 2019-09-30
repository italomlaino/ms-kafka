package com.italomlaino.ms.order.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long customerId;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	@Email
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
