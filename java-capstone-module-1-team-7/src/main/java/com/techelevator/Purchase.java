package com.techelevator;
import java.math.BigDecimal;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Purchase {

	private double balance;
	double moneyFed = 0.00;
	double finalChange = 0.00;
	
	public double feedMoney(double currency) {
		
		File log = new File("log.txt");
		try(PrintWriter writer = new PrintWriter(new FileWriter(log, true)))
		{
			LocalDateTime dateAndTime = LocalDateTime.now();
			writer.print(dateAndTime + " ");
			writer.print("MONEY FED: " + getBalance() + " 0.00");
		}
		catch(Exception e)
		{
			System.out.println("The log was not written!");
		}
		
		if ((currency == 1.00) || (currency == 2.00) || (currency == 5.00) || (currency == 10.00)) {
			balance += currency;
			moneyFed += currency;
		}
		else {
			System.out.println("That is not a value that can be accepted by the machine: ");
		}
		return balance;
		
		
	}
	
	
	// Following RomanNumeral exercise as an example
	public String makeChange() {
		int qCounter = 0;
		int dCounter = 0;
		int nCounter = 0;
		
		
		finalChange = balance;
		
		File log = new File("log.txt");
		try(PrintWriter writer = new PrintWriter(new FileWriter(log, true)))
		{
			LocalDateTime dateAndTime = LocalDateTime.now();
			writer.println(dateAndTime + " ");
			writer.print("GIVE CHANGE: " + getBalance() + " 0.00");
		}
		catch(Exception e)
		{
			System.out.println("The log was not written!");
		}
		
		
		while( balance >= 0.25 ) {
			qCounter++;
			balance -= 0.25;
		}
		
		while ( balance >= 0.10 ) {
			dCounter++;
			balance -= 0.10;
		}
		
		while ( balance >= 0.05 ) {
			nCounter++;
			balance -= 0.05;
		}
		
		BigDecimal bdBalance = new BigDecimal(0);
		bdBalance = bdBalance.valueOf(balance);
		
		return "Your change consists of " + qCounter + " quarters, " + dCounter + " dimes, and " + 
				nCounter + " nickles. Your balance is now $" + bdBalance;
		
	}
	
	
//	public void createLog(String slot, String name, double price) { //double moneyFed, double finalChange) {
		
//		File log = new File("log.txt");
		
//		try(PrintWriter writer = new PrintWriter(new FileWriter(log)))
//		{
			
//			LocalDateTime dateAndTime = LocalDateTime.now();
//			writer.print(dateAndTime + " ");
//			writer.print("Feed Money: ");
//			writer.print(moneyFed + " " + balance);
//			writer.print(" > ");
//			writer.print(dateAndTime + " ");
//			writer.print(name + " ");
//			writer.print(slot + " ");
//			writer.print(balance + " ");
//			writer.print(balance - price);
//			writer.print(" > ");
//			writer.print(dateAndTime + " : GIVE CHANGE ");
//			writer.print(finalChange + " ");
//			writer.print(balance);
//		}
//		catch(Exception e)
//		{
//			System.out.println("The transaction was not logged!");
//			System.out.println(e.getMessage());
//		}
//		finally {
//			System.exit(0);
//		}
//	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance( double balance ) {
		this.balance = balance;
	}
}
