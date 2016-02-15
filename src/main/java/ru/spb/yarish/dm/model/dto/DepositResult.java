package ru.spb.yarish.dm.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter
public class DepositResult {

    private Long id;
    private String number;
    private Double balance;
    private String account;
    private Date creationDate;
}
