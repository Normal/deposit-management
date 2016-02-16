package ru.spb.yarish.dm.model;

/**
 * Indicates some critical validation errors in transaction input.
 */
public class TransactionConstraintsViolationException extends RuntimeException {

    public TransactionConstraintsViolationException(String message) {
        super(message);
    }
}
