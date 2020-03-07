package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		File newfile = new File("vendingmachine.csv");
		Purchase p;
		VendingMachine vm = new VendingMachine(newfile);

		// Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("(1) See Items available");
			System.out.println("(2) Make a purchase");
			System.out.println("(3) Exit");
			int selector = scanner.nextInt();
			if (selector == 1) {
				for (String items : vm.displayItems()) {
					System.out.println(items);
				}
			}
			if (selector == 2) {
				p = new Purchase();
				while (true) {
					System.out.println("(1) Feed Money");
					System.out.println("(2) Select Item");
					System.out.println("(3) Finish Transaction");

					int purchaseSelector = scanner.nextInt();

					if (purchaseSelector == 1) {
						System.out.println("Enter Money: ");
						int initialBalance = scanner.nextInt();
						p.feedMoney(initialBalance);
						System.out.println("Your current balance is: " + p.getBalance());

					}

					if (purchaseSelector == 2) {

						for (String items : vm.displayItems()) {
							System.out.println(items);
						}
						System.out.println("Select an item from the above list: ");
						scanner.reset();
						String selectItem = scanner.next().toUpperCase();
						vm.makeAPurchase(p, selectItem);

					}

					if (purchaseSelector == 3) {
						System.out.println(p.makeChange());
						//p.createLog(vm.getInvList().get(slot), name, price, moneyFed, finalChange);
						System.out.println("Thank you!");
						System.exit(1);
					}
				}

				}
		if (selector ==3 ){
			System.out.println("Thank you!");
			System.exit(1);
		}
		}
	}

}
