package com.giwaintl.freeDom.model.type;

import com.giwaintl.freeDom.model.Fqn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Jorge U
 */
public class DomEnumType extends DomObjectType {
    private String[] ordToWord;
    private LinkedHashMap<String, Integer> wordToOrd;


    private DomEnumType(Fqn name) {
        super(name);
    }

    public Integer ord(final String name) {
        return wordToOrd.get(name);
    }

    public String name(final int ord) {
        if(ord < 0 || ord >= ordToWord.length) throw new IllegalArgumentException("Ord " + ord
            + " of the enum " + getName().getKey() + "queried; valid ords 0 to " + (ordToWord.length - 1));
        return ordToWord[ord];
    }

    public List<String> names() {
        return Arrays.asList(ordToWord);
    }

    private void registerNames(final List<String> names) {

        final int size = names.size();
        ordToWord = new String[size];
        wordToOrd = new LinkedHashMap<>(size * 3 /2 + 1);
        // zero based like Java enums, makes calc easier
        for(int index = 0; index < size; index ++) {
            final String n = names.get(index);
            ordToWord[index] = n;
            wordToOrd.put(n, index);
        }
        // don't worry about immutable, we don't change it, world does not change it.
    }

    // list not set, originally ordered
    public static DomEnumType buildFrom(final Fqn fqn, final List<String> names) {
        if ((new HashSet<>(names).size()) != names.size()) throw new IllegalArgumentException("Duplicate names in ");
        DomEnumType result = new DomEnumType(fqn);
        result.registerNames(names);
        return result;
    }
}

