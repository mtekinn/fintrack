package com.example.fintrack.service;

import com.example.fintrack.dto.SummaryResponse;
import com.example.fintrack.dto.TransactionResponse;
import com.example.fintrack.entity.Transaction;
import com.example.fintrack.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionResponse> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(t-> new TransactionResponse(
                        t.getId(),
                        t.getAmount(),
                        t.getDescription(),
                        t.getType(),
                        t.getDate(),
                        t.getUser().getEmail(),
                        t.getCategory().getName()
                ))
                .collect(Collectors.toList());
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public SummaryResponse getSummary(Long userId) {
        double totalIncome = transactionRepository.findByUserIdAndType(userId, "INCOME")
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalExpense = transactionRepository.findByUserIdAndType(userId, "EXPENSE")
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        double netBalance = totalIncome - totalExpense;

        return new SummaryResponse(totalIncome, totalExpense, netBalance);
    }
}
