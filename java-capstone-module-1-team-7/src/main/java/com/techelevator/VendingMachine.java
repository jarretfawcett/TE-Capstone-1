package com.techelevator;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachine {
	private Map<String, Item> invList = new LinkedHashMap<>();

	public Map<String, Item> getInvList() {
		return invList;
	}

	private int salesTotal = 0;

	public VendingMachine(File file) throws FileNotFoundException {
		Scanner fileReader = new Scanner(file);
		DecimalFormat df2 = new DecimalFormat("#.##");
		while (fileReader.hasNextLine()) {
			String[] description;
			description = fileReader.nextLine().split("\\|");
			double price = Double.parseDouble(description[2]);
			invList.put(description[0], new Item(description[0], description[1], price, description[3], 5));

		}
	}

	public List<String> displayItems() {

		List<String> itemsAsAList = new ArrayList<>();
		Set<String> keys = invList.keySet();
		for (String key : keys) {
			Item it = invList.get(key);
			StringBuffer itemAsString = new StringBuffer();
			itemAsString.append(it.getSlot() + " - ");
			itemAsString.append(it.getName() + " - ");
			itemAsString.append(it.getPrice() + " - ");

			if (it.getStock() == 0) {
				itemAsString.append(" - Out of Stock.");
			} else {
				itemAsString.append("Stock: " + it.getStock());
				itemsAsAList.add(itemAsString.toString());

			}
		}
		return itemsAsAList;
	}

	public void makeAPurchase(Purchase p, String slot) {
		File log = new File("log.txt");
		try(PrintWriter writer = new PrintWriter(new FileWriter(log, true)))
		{
			LocalDateTime dateAndTime = LocalDateTime.now();
			writer.println(dateAndTime + " ");
			writer.print("Item: " + this.getInvList().get(slot).getName() + " " + getInvList().get(slot).getPrice() + " " + p.getBalance());
		}
		catch(Exception e)
		{
			System.out.println("The log was not written!");
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("You have chosen: " + getInvList().get(slot).getName());
		System.out.println("********************");
		System.out.println("********************");
		double balance = p.getBalance();

		if (this.getInvList().get(slot).getStock() == 0) {
			System.out.println("*****************************************");
			System.out.println("*** Sorry. This item is out of stock. ***");
			System.out.println("*** Please   select   another   item. ***");
			System.out.println("*****************************************");

		} else if (getInvList().get(slot).getPrice() < balance) {
			this.getItem(slot).setStock(getItem(slot).getStock() -1);
			System.out.println("*** Purchase successful. ***");
			System.out.println("Thank you for purchasing " + getInvList().get(slot).getName());
			System.out.println(this.getItem(slot).getSaying(slot));
			balance -= getInvList().get(slot).getPrice();
			p.setBalance(balance);
			System.out.println("You have $" +  p.getBalance() + " remaining.");
			System.out.println("********************");
			salesTotal++;
		} else if (balance < this.getItem(slot).getPrice() ) {
			System.out.println("You cannot afford this item because you're a junior developer.");

		}


	}
	public Item getItem(String slot) {
		return invList.get(slot);
	}

/*	public void printReport() throws IOException {
		List<String> itemList = new ArrayList<>();
		Set<String> keys = invList.keySet();
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-DD-YYYY-hh:mm_a");
		File report = new File("VendingMachineSales" + format.format(dateTime) + ".txt");
		PrintWriter writer = new PrintWriter(new FileWriter(report, true));
		for (String i : keys){

			Item it = invList.get(i);
			String line = it.getName() + "//|";
			writer.println(line);
		}
		Purchase x = new Purchase();
		//writer.println("Total Sales: " + x.getBalance(salesTotal));

		// we need to create a method to return individual sales per item in the purchase class


	}
*/
}
