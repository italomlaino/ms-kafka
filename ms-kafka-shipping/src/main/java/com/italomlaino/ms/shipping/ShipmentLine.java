package com.italomlaino.ms.shipping;

import javax.persistence.*;

@Entity
public class ShipmentLine {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "F_COUNT")
	private int count;

	@Embedded
	private Item item;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
