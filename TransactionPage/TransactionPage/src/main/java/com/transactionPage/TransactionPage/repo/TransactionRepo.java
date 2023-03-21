package com.transactionPage.TransactionPage.repo;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
	List<Transaction> findByTransAccountNumber(@Param("AccountNumber")String AccountNumber);

}
