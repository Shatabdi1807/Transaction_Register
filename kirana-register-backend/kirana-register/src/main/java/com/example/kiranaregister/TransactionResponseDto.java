package com.example.kiranaregister;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionResponseDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7648502899921036102L;
	
	private int transactionId;
	
	private String date;
	
	private double amount_INR;
	
	private double amount_USD;
	
	private String type;
	
	public TransactionResponseDto(KiranaTransactionEntity transaction) {
		setTransactionId(transaction.getTransactionId());
		setDate(transaction.getDate());
		setType(transaction.getType());
		double amount = transaction.getAmount();
		if(transaction.getCurrency().equals("INR")) {
			setAmount_INR(amount);
			setAmount_USD(amount / 83.2348708666);
		}else if(transaction.getCurrency().equals("USD")) {
			setAmount_USD(amount);
			setAmount_INR(amount * 83.2348708666);
		}
	}


}
