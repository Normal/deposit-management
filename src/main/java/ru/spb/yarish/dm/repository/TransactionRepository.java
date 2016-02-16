package ru.spb.yarish.dm.repository;

import org.springframework.stereotype.Repository;

import ru.spb.yarish.dm.model.entity.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TransactionRepository {

    @PersistenceContext
    private EntityManager em;

    public void create(Transaction transaction) {
        em.persist(transaction);
    }
}
