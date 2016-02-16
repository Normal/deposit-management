package ru.spb.yarish.dm.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "deposits")
@Getter @Setter
@EqualsAndHashCode(exclude={"id", "balance", "account"})
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "closed")
    private Boolean closed = false;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
