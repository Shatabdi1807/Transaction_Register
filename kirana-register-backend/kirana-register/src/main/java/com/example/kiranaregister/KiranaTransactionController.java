package com.example.kiranaregister;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/transactions")
public class KiranaTransactionController {
	
	@Autowired
	private KiranaTransactionService srvc;

	@Operation(description = "Add/Record Transaction", summary = "For recording Transaction")
	@PostMapping("/record")
	public Map<String, Object> recordTransaction(@RequestBody TransactionRequestDto transaction) {
		return srvc.recordTransaction(transaction);
	}

	@Operation(description = "Get transactions by date", summary = "Used to get transactions by date")
	@GetMapping("/byDate")
	public List<TransactionResponseDto> getDailyTransaction(@RequestBody Map<String, Object> date) throws IllegalArgumentException{
		if(srvc.isValidFormat(date)) {
			return srvc.getDailyTransaction(date);
		}else {
			throw new IllegalArgumentException("Invalid input format.");
		}
	}
	
	@Operation(description = "Get all transactions", summary = "Get all transactions")
	@GetMapping("/all")
	public List<TransactionResponseDto> getAllTransactions() {
		return srvc.getAllTransactions();
	}
}
