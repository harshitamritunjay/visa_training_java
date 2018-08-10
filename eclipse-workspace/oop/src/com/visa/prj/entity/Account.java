/**
 * 
 */
package com.visa.prj.entity;

/**
 * @author Administrator
 *
 */
public class Account {
	
	/*
	 * state of objects
	 * account number and balance
	 */
	private String accNo;
	private double balance; //state of object
	private static int count;
	public Account() {
		super();
		count++;
	}



	public Account(String accNo) {
		super();
		this.accNo = accNo;
		count++;
	}

	

	/**
	 * This method id to credit amount into account
	 * @param amt amount to be credited
	 */
	
	public void deposit(double amt) { //public void deposit(Account this,double amt)
		balance+=amt;                 //this.balance+=amt;
	}
	
	/**
	 * This method returns current account balance
	 * 	 
	 * @return current balance
	 */
	public double getBalance() {
		return balance;
	}
	
	public String getAccno()
	{
		return this.accNo;
	}
	
	public boolean equals(Object obj) {  //over riding
		Account other= (Account)obj;
		return (this.accNo.equals(other.accNo));
    }
	
	public static int getCount() {
		return count;
	}
}

