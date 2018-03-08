package com.falcon.wolf.implementation;

public class EntityConstraintViolationException extends RuntimeException {

    public EntityConstraintViolationException(String entitySimpleName, String pk) {
        super(String.format("Entity: %s with id: %s has uniqueconstraint.", entitySimpleName, pk));
    }
}
