//AbdAl-rheem yaseen 1220783
//Anas Al-sayed 1221020

import java.util.Scanner;

class Account {
	private int id;
	private String name;
	private long phone;
	private char type;
	private double balance;
	public Account[] abc;


	Bank b = new Bank();
	Scanner input = new Scanner(System.in);

	Account() {
		// Default constructor
	}

	Account(int id, String name, long phone, char type, double balance) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.type = type;
		this.balance = balance;
	}
	// Getter methods
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPhone() {
		return phone;
	}

	public char getType() {
		return type;
	}

	public double getBalance() {
		return balance;
	}
	// Setter methods
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setType(char type) {
		this.type = type;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	// Method to withdraw amount from the account
	public void withdrawAmount(double amount) {

		
		if (this.getType() != 's') {
			if (amount > balance) {
				System.out.print("You dont have this amount..");
				System.out.println("Avaliable balance is: $"+this.getBalance());
			}
			else {
				this.balance -= amount;
				System.out.println("$" + amount + " discounted successfully.");
				System.out.println("Avaliable balance is: $"+this.getBalance());
			}
		} else {
			if (amount > 500) {

				System.out.println("Can't do this ,Beacause your account type is saving");
			} else if (amount < 500) {
				if (amount > balance) {
					System.out.println("You dont have this amount..");
					
				}
			} else {

				this.balance -= amount;
				System.out.println("$" + amount + " discounted successfully.\n");
			}
		}
	}

	public void addAmount(double amount) {
		//A method to add amount to the account
		this.balance += amount;
		System.out.print("$" + amount + " added successfully.\n");
	}

	public void modifyAccountDetails(int i){
		//A method to modify The Account
		System.out.println("The order of your  account : "+i);

		System.out.print("Enter The new ID: ");
		int newID=input.nextInt();
		this.setId(newID);
		System.out.print("Enter the new Name: ");
		String newname=input.next();
		this.setName(newname);
		System.out.print("Enter the new Phone Number: ");
		long newphone=input.nextLong();
		this.setPhone(newphone);
		System.out.print("Enter the new account type: ");
		char newtype=input.next().charAt(0);
		this.setType(newtype);
		System.out.print("Enter the new balance: ");
		double newbalance=input.nextDouble();
		this.setBalance(newbalance);
		System.out.println("* Account Details Modified sucssefully *");
	}

}