package ru.spb.yarish.dm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.yarish.dm.model.TransactionConstraintsViolationException;
import ru.spb.yarish.dm.model.entity.Deposit;
import ru.spb.yarish.dm.model.entity.Transaction;
import ru.spb.yarish.dm.repository.DepositRepository;
import ru.spb.yarish.dm.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Transactional
    public void processTransaction(Transaction tr) {
        if (tr.getFromDeposit() == null || tr.getToDeposit() == null) {
            throw new TransactionConstraintsViolationException("Deposits should be determined");
        }
        Deposit from = depositRepository.getByNumber(tr.getFromDeposit());
        Deposit to = depositRepository.getByNumber(tr.getToDeposit());

        double fromBalance = from.getBalance() - tr.getAmount();
        if (fromBalance < 0) {
            throw new TransactionConstraintsViolationException("Balance can't be negative");
        }

        from.setBalance(fromBalance);
        to.setBalance(to.getBalance() + tr.getAmount());

        transactionRepository.create(tr);
    }
}
