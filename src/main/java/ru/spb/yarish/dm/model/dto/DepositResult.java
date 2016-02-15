package ru.spb.yarish.dm.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DepositResult {

    private Long id;
    private String number;
    private Double balance;
    private String account;
    private String creation;
}
