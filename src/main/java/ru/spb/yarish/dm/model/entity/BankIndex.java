package ru.spb.yarish.dm.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "indexes")
@Getter @Setter
public class BankIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "value", nullable = false, unique = true)
    private String value;
}
