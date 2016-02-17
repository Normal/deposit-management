package ru.spb.yarish.dm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import ru.spb.yarish.dm.model.TransactionConstraintsViolationException;
import ru.spb.yarish.dm.model.entity.Deposit;
import ru.spb.yarish.dm.model.entity.Transaction;
import ru.spb.yarish.dm.repository.DepositRepository;
import ru.spb.yarish.dm.repository.TransactionRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
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

    @Transactional
    public List<Transaction> getByUser(String userName) {
        return transactionRepository.getByUser(userName);
    }

    /**
     * Everyday at 2 AM
     */
    @Scheduled(cron = "0 0 2 * * ?")
    @Transactional
    public void removeStaleTransactions() {
        log.debug("Scheduler was triggered!");
        LocalDate boundary = LocalDate.now().minusDays(30);
        transactionRepository.removeStale(Date.valueOf(boundary));
    }
}
