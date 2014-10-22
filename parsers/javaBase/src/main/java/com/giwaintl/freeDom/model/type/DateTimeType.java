package com.giwaintl.freeDom.model.type;

import org.joda.time.DateTime;

/**
 * @author elim
 */
public final class DateTimeType extends StdType<DateTime> {
    public final static String NAME = "datetime";

    protected DateTimeType() {
        super(NAME);
    }

    @Override public Class<DateTime> getKlass() {
        return DateTime.class;
    }
}
