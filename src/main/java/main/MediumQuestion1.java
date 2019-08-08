package main;

import java.util.Scanner;

abstract class Customer {

	private String name, address, mobileNumber;

	private Integer age;

Customer(String name, String address, Integer age, String mobile) {

	this.name = name;
	this.address = address;
	this.age = age;
	this.mobileNumber = mobile;

}

public String toString() {
	return "Name: " + this.name+"\n"+"Mobile: "+this.mobileNumber+"\n"+"Age: " + this.age+"\n"+"Address: "+ this.address;
}
abstract Double getBillAmount(Double amt);

}

class SeniorCitizenCustomer extends Customer {

	SeniorCitizenCustomer(String name, String address, Integer age, String mobile) {
		super(name, address, age, mobile);
	}
	
	Double getBillAmount(Double amount) {
		
        Double R=amount*10/100;
		Double bill=amount - R-10;
		 //edit as per the question
		//Write your code here of required
		
		
		return bill;
	}

}

class PrivilegeCustomer extends Customer {
	PrivilegeCustomer(String name, String address, Integer age, String mobile) {
			super(name, address, age, mobile);
		}
		Double getBillAmount(Double amount) {
			Double R=amount*30/100;
			Double bill=amount - R;
			return bill;
		}
}

public class MediumQuestion1 {
	static Scanner in = new Scanner(System.in);
	static String name, address, phn;
	static Integer age;
	static Double purchasedAmt;
	public static void main(String[] args) {
		
		System.out.print("1)Privilege Customer" + "\n" + "2)Senior Citizen \n");
		System.out.println("Enter Customer Type: ");
		int select = in.nextInt();
		switch (select) {
			case 1:
			
				takeInput();
				
				Customer cust = new PrivilegeCustomer(name, address, age, phn);
				//Double billAmt = cust.getBillAmount(purchasedAmt);
				System.out.println("Bill details");
				System.out.println(cust.toString()+"\n"+"Your bill amount is Rs."+purchasedAmt+" Congrats! As you are a Privileged"+"\n"+"customer, you are eligible for a discount!"+"\n"+"You have to pay Rs "+ cust.getBillAmount(purchasedAmt));
				
				
				break;
			case 2:
				takeInput();
				Customer cust1 = new SeniorCitizenCustomer(name, address, age, phn);
				
				System.out.println("Bill details");
		 		
				//System.out.println(cust1.toString()+"\n"+cust1.getBillAmount(purchasedAmt));
				System.out.println(cust1.toString()+"\n"+"Your bill amount is Rs."+purchasedAmt+" Congrats! As you are Senior "+"\n"+"Citizen, you are eligible for a discount!"+"\n"+"You have to pay Rs "+ cust1.getBillAmount(purchasedAmt));
				
				break;
				
			default:
				System.out.println("Invalid Customer Type");
				break;
			}
}

public static void takeInput() {

		System.out.println("Enter the name: ");
		
		in.nextLine();
		
		name = in.nextLine();
		
		System.out.println("Enter the age: ");
		
		age = in.nextInt();
		
		System.out.println("Enter the address: ");
		
		in.nextLine();
		
		address = in.nextLine();
		
		System.out.println("Enter the mobile number: ");
		
		phn = in.nextLine();
		
		System.out.println("Enter the purchased amount: ");
		
		purchasedAmt = in.nextDouble();

	}

}