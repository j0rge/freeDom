package com.giwaintl.freeDom.model;

/**
 * @author Jorge U
 */
public class Identifier {
    private final String id;

    public Identifier(String id) {
        this.id = id;
    }
    @Override public String toString() { return id; }
}
