package com.giwaintl.freeDom.model.type;

/**
 * Standard type - always implies a Java class either in JDK or in a popular 3<sup>rd</sup> party library such as
 * <a target="_blank" href="http://www.joda.org/joda-time">Joda</a>.
 * Classes for instances of this type should be available in the classpath of this product, included.
 */
public abstract class StdType<T> implements FreeDomType {
    /**
     * Standard package denominator, for standard FreeDom types.
     */
    //public final static String STD_PKG = "/";

    private final String name;

    protected StdType(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    /**
     * Instance class for this type. Must be available in the classpath.
     */
    public abstract Class<T> getKlass();
}
