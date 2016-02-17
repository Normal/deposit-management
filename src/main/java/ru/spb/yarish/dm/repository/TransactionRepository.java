package ru.spb.yarish.dm.repository;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import ru.spb.yarish.dm.model.entity.Transaction;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Slf4j
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

    public void removeStale(Date boundary) {
        long rows = em.createQuery("delete from Transaction where creationDate <?")
                .setParameter(1, boundary)
                .executeUpdate();
        log.debug("Rows deleted:" + rows);
    }
}
