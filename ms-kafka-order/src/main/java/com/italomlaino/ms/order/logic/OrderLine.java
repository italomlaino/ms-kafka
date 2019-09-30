package com.italomlaino.ms.order.logic;

import com.italomlaino.ms.order.item.Item;

import javax.persistence.*;

@Entity
public class OrderLine {

	@Column(name = "F_COUNT")
	private int count;

	@ManyToOne
	private Item item;

	@Id
	@GeneratedValue
	private long id;

	public OrderLine() {
	}

	public OrderLine(int count, Item item) {
		this.count = count;
		this.item = item;
	}

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
