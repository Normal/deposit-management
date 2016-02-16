package ru.spb.yarish.dm.repository;

import org.springframework.stereotype.Repository;

import ru.spb.yarish.dm.model.entity.Transaction;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TransactionRepository {

    @PersistenceContext
    private EntityManager em;

    public void create(Transaction transaction) {
        em.persist(transaction);
    }

    public List<Transaction> getByUser(String userName) {
        return em.createQuery("from Transaction where user=?", Transaction.class)
                .setParameter(1, userName)
                .getResultList();
    }
}
