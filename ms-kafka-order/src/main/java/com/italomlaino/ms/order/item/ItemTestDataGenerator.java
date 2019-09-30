package com.italomlaino.ms.order.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class ItemTestDataGenerator {

	private final ItemRepository itemRepository;

	@Autowired
	public ItemTestDataGenerator(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@PostConstruct
	public void generateTestData() {
		Item iPod = new Item();
		iPod.setName("iPod");
		iPod.setPrice(42.0);

		Item iPodTouch = new Item();
		iPodTouch.setName("iPod touch");
		iPodTouch.setPrice(21.0);

		Item iPodNano = new Item();
		iPodNano.setName("iPod nano");
		iPodNano.setPrice(1.0);

		Item appleTv = new Item();
		appleTv.setName("Apple TV");
		appleTv.setPrice(100.0);

		itemRepository.saveAll(Arrays.asList(iPod, iPodTouch, iPodNano, appleTv));
	}

}
