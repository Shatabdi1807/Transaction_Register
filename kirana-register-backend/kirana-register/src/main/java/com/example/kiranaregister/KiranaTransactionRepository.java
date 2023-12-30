package com.example.kiranaregister;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KiranaTransactionRepository extends JpaRepository<KiranaTransactionEntity, Integer>{

	@Query(value = "SELECT * FROM kirana_transactions WHERE date = :date", nativeQuery = true)
	List<KiranaTransactionEntity> findByDate(String date);
}
