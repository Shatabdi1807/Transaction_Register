package com.example.kiranaregister;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "kirana_transactions")
public class KiranaTransactionEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6333479672070426316L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int transactionId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private String date;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "type")
	private String type;
	
	public KiranaTransactionEntity(TransactionRequestDto dto) {
		setDate(dto.getDate());
		setAmount(dto.getAmount());
		setCurrency(dto.getCurrency().toString());
		setType(dto.getType().toString());
	}

	
}
