package com.example.kiranaregister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class KiranaTransactionService {
	
	@Autowired
	private KiranaTransactionRepository transactionRepo;
	
	@Transactional
	public Map<String, Object> recordTransaction(TransactionRequestDto dto){
		Map<String, Object> map = new HashMap<>();
		try {
			if(dto != null) {
				KiranaTransactionEntity transaction = new KiranaTransactionEntity(dto);
				transactionRepo.save(transaction);
				map.put("message", "Transaction recorded successfully");
			}
		}catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Transaction recording failed");
		}
		return map;
	}

	public List<TransactionResponseDto> getDailyTransaction(Map<String, Object> dateFormat) {
		List<KiranaTransactionEntity> transactionData = null;
		List<TransactionResponseDto> transactions = new ArrayList<>();
		try {
			transactionData = transactionRepo.findByDate((String) dateFormat.get("date")); 
			for(KiranaTransactionEntity transaction: transactionData) {
				TransactionResponseDto dto = new TransactionResponseDto(transaction);
				transactions.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return transactions;
	}

	public boolean isValidFormat(Map<String, Object> date) {
		if(date.containsKey("date")) {
			return true;
		}
		return false;
	}

	public List<TransactionResponseDto> getAllTransactions() {
		List<KiranaTransactionEntity> transactionData = null;
		List<TransactionResponseDto> transactions = new ArrayList<>();
		try {
			transactionData = transactionRepo.findAll(); 
			for(KiranaTransactionEntity transaction: transactionData) {
				TransactionResponseDto dto = new TransactionResponseDto(transaction);
				transactions.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return transactions;
	}

}
