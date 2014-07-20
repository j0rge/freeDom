package com.giwaintl.freeDom.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Jorge U
 */
public class FreeformVersion implements AnyVersion {
    private String version;

    @Override public int compareTo(Object other) {
        if(! (other instanceof String)) throw new IllegalArgumentException("Not a string: " + ReflectionToStringBuilder.reflectionToString(other));
        return version.compareTo((String) other);
    }
}
