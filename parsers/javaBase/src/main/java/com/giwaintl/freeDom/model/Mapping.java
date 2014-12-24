package com.giwaintl.freeDom.model;

/**
 * Mapping of any Key type to any Value type
 * @author Michael Bergens
 */
public interface Mapping<K,V> {
    void setKey(K key);
    K getKey();
    V getValue();

}
