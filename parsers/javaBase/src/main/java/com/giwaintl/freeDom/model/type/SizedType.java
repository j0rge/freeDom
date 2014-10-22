package com.giwaintl.freeDom.model.type;

/**
 * Doubles as a type declaration with the given size.
 * @author azimsk Azim Sankarbekov
 */
public abstract class SizedType<T> extends StdType<T> {
    private int size;
    protected SizedType(String name) {
        super(name);
    }

    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }
}
