package com.giwaintl.freeDom.model;

/**
 * @author Jorge U
 */
public class Field {
    private boolean isRequired;
    private boolean isPrim; // primitive

    private Fqn name;

    public Fqn getName() {
        return name;
    }
}
