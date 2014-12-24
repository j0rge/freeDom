package com.giwaintl.freeDom.model;

import com.giwaintl.freeDom.model.type.FreeDomType;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

/**
 * @author Jorge U
 */
public class Field<T> implements Comparator<Field<?>> {
    private boolean isRequired;
    private boolean isPrim; // the field has a "primitive" type, not in Java sense but in FreeDOM sense.

    private T value;
    private String name;

    private FreeDomType type;

    public String getName() {
        return name;
    }

    @Override public int hashCode() {
        return name.hashCode();
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass") /* let it fail if it's wrong class, there should be no comparison of
         apples to oranges and we should get all the details in the stack trace */
    @Override public boolean equals(Object obj) {
        Field<?> other = (Field<?>) obj;
        return name.equals(other.name);
    }

    @Override public int compare(Field<?> o1, Field<?> o2) {
        return o1.name.compareTo(o2.name);
    }
}
