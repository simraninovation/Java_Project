package com.Transcation.Transcation.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Transcation.Transcation.entities.Transcation;

@Repository
public interface TransactionRepository extends JpaRepository<Transcation,Long>{

List<Transaction> findByAccountNumber(String AccountNumber);
@Modifying
@Query("Insert INTO Transaction(TransId,amount,transaction_Type)values(:accountId,:amount,'DEPOSIT')")
int insertDepositTransaction(@Param("TransId") Long accountId, @Param("amount") BigDecimal amount);
@Modifying
@Query("Insert INTO Transaction(TransId,amount,transaction_Type)values(:accountId,:amount,'Withdrawal')")
int insertWithdrawalTransaction(@Param("TransId") Long accountId, @Param("amount") BigDecimal amount);
}