package com.giwaintl.freeDom.model;

/**
 * @author Jorge U
 */
public class Field<T> {
    private boolean isRequired;
    private boolean isPrim; // the field has a "primitive" type, not in Java sense but in FreeDOM sense.

    private T value;
    private Fqn name;

    private FreeDomType type;

    public Fqn getName() {
        return name;
    }
}
