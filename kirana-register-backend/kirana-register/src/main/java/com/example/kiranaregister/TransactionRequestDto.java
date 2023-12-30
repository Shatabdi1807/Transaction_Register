package com.example.kiranaregister;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionRequestDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8906404093412874749L;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private String date;
	
	private float amount;
	
	private CurrencyType currency;
	
	private TransactionType type;
	
}
