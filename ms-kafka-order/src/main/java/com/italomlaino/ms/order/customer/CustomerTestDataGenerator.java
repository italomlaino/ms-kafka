package com.italomlaino.ms.order.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CustomerTestDataGenerator {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerTestDataGenerator(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@PostConstruct
	public void generateTestData() {
		Customer customer = new Customer();
		customer.setFirstName("John");
		customer.setLastName("Wick");
		customer.setEmail("john.wick@gmail.com");

		customerRepository.save(customer);
	}

}
