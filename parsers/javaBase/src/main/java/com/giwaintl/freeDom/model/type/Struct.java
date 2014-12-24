package com.giwaintl.freeDom.model.type;

import com.giwaintl.freeDom.model.Field;
import com.giwaintl.freeDom.model.Fqn;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jorge U
 */
public class Struct extends DomObjectType {

    private final List<Field<?>> fields;

    public Struct(Fqn name) {
        super(name);
        fields = new LinkedList<>();
    }

    public void add(final Field<?> fld) {
        fields.add(fld);
    }

}
