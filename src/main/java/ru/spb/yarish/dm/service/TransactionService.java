package ru.spb.yarish.dm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.yarish.dm.model.entity.Transaction;
import ru.spb.yarish.dm.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void processTransaction(Transaction transaction) {
        // TODO: create logic here
        transactionRepository.create(transaction);
    }
}
