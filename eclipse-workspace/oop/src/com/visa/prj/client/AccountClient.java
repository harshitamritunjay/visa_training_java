package com.visa.prj.client;

import com.visa.prj.entity.Account;

public class AccountClient {

	public static void main(String[] args) {
		System.out.println(Account.getCount());
		Account rahulAcc =  new Account();
		System.out.println(Account.getCount());

		Account swethaAcc = new Account("SB120");
		System.out.println(Account.getCount());

		rahulAcc.deposit(4500.00); //deposit(rahulAcc,4500.00);
		swethaAcc.deposit(6780.00);
		
		System.out.println(rahulAcc.getBalance());
		System.out.println(swethaAcc.getBalance());

		System.out.println(rahulAcc.getAccno());
		System.out.println((swethaAcc.getAccno()));
		
		Account smithaAcc = new Account("SB120");
		System.out.println(Account.getCount());

		smithaAcc.deposit(6780.00);
		
		Account other = smithaAcc;
		
		if( other == smithaAcc) {
			System.out.println("Both are same [other == smithaAcc]");
		}

		if( swethaAcc == smithaAcc) {
			System.out.println("Both are same [other == smithaAcc]");
		}
		if(swethaAcc.equals(smithaAcc)) {
			System.out.println("both are similar [swethaAcc.equals(smithaAcc)]");
		}
	}

}
