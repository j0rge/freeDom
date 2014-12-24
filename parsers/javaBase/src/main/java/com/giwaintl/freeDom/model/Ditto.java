package com.giwaintl.freeDom.model;

/**
 * Interface facilitating comparison of the object instances to each other; not quite comparator.
 * @author Michael Bergens
 * @author Azim Sankar
 * @param <T> the type to be compared with this class/instance
 */
public interface Ditto<T> {

    /**
      * Leverages the {@link Object#equals(Object)} (re)defined on the class.
      * The {@link #isIdem(Object, Object)} method returns <tt>true</tt> if
      * both instances are <tt>null</tt> or <tt>one</tt> is not null and it <tt>equals</tt> the
      * <tt>another</tt>.
      */
     static Ditto<Object> EQ = new Ditto<Object>() {
         @Override public boolean isIdem(Object one, Object another) {
             return one == another || (one != null && one.equals(another));
         }
     };

    /**
     * Determines if the arguments are the <i>same</i> in certain applicable sense.
     */
    boolean isIdem(T one, T another);
}
