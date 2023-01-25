package com.example.RelationClientBanque.services;

import com.example.RelationClientBanque.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceTransaction {
    public List<Transaction> getAllTransactions();
    public Transaction getTransactionById(Long id);
    public Transaction createTransaction(Transaction transaction);
    public Transaction updateTransaction(Long id,Transaction transaction);
    public void deteTransation(Long i);
}
