package ru.spb.yarish.dm.model.entity;

import lombok.Getter;
import lombok.Setter;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
@Getter @Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "user")
    private String user;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "from_deposit")
    private String fromDeposit;

    @Column(name = "to_user")
    private String toUser;

    @Column(name = "to_deposit")
    private String toDeposit;

    @Column(name = "created")
    private Date creationDate;

    @PrePersist
    protected void onCreate() {
        creationDate = new Date(new java.util.Date().getTime());
    }
}
