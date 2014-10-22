package com.giwaintl.freeDom.model.type;

/**
 * @author elim
 */
public class TextualType extends SizedType<String> {

    protected TextualType(String name) { super(name); }

    @Override public final Class<String> getKlass() { return String.class; }
}
