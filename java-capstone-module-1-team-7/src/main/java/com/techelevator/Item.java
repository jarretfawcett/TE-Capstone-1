package com.techelevator;

public class Item {

	private String slot;
	private String name;
	private double price;
	private String type;
	private String saying;
	private int stock;

	public Item(String slot, String name, double price, String type, int Stock) {
		this.slot = slot;
		this.name = name;
		this.price = price;
		this.type = type;
		this.stock = 5;
	}

	public String getSaying(String slot) {
		if (slot.contains("A")) {
			saying = "Crunch Crunch, Yum!";
		} else if (slot.contains("B")) {
			saying = "Munch Munch, Yum!";
		} else if (slot.contains("C")) {
			saying = "Glug Glug, Yum!";
		} else if (slot.contains("D")) {
			saying = "Chew Chew, Gum";
		}
		return saying;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void stockCounter() {
		if (stock > 0) {
			stock--;
		}
	}

	public String getType() {
		return type;
	}

}
