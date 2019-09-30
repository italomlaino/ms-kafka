package com.italomlaino.ms.shipping;

import javax.persistence.Embeddable;

@Embeddable
public class Item {

	private Long itemId;

	private String name;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
