package com.italomlaino.ms.order.logic;

import com.italomlaino.ms.order.customer.Customer;
import com.italomlaino.ms.order.customer.CustomerRepository;
import com.italomlaino.ms.order.item.Item;
import com.italomlaino.ms.order.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class OrderController {

	private OrderRepository orderRepository;
	private OrderService orderService;
	private CustomerRepository customerRepository;
	private ItemRepository itemRepository;

	@Autowired
	private OrderController(OrderService orderService, OrderRepository orderRepository, CustomerRepository customerRepository, ItemRepository itemRepository) {
		this.orderService = orderService;
		this.orderRepository = orderRepository;
		this.customerRepository = customerRepository;
		this.itemRepository = itemRepository;
	}

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public Iterable<Item> itemList() {
		return itemRepository.findAll();
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public Iterable<Customer> customerList() {
		return customerRepository.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Order> orderList() {
		return orderRepository.findAll();
	}

	@RequestMapping(value = "/line", method = RequestMethod.POST)
	public Order addLine(@RequestBody Order order) {
		order.addLine(0, itemRepository.findAll().iterator().next());
		return order;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order get(@PathVariable("id") long id) {
		return orderRepository.findById(id).get();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void post(@RequestBody Order order) {
		orderService.order(order);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void post(@PathVariable("id") long id) {
		orderRepository.deleteById(id);
	}
}
