package com.giwaintl.freeDom.model;

import org.apache.commons.collections4.list.UnmodifiableList;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Joiner.on;
import static java.util.Arrays.asList;

/**
 * Fully qualified name
 * @author Jorge U
 */
@SuppressWarnings("EqualsWhichDoesntCheckParameterClass") public class Fqn {
    private final List<String> ids;

    private final String base;

    private final List<String> nsParts;
    private final String nameSpace;

    @Nonnull private final String key;

    public Fqn(List<String> ids) {
        this.ids = new UnmodifiableList<>(ids);
        final int lastIndex = ids.size() - 1;
        base = ids.get(lastIndex);


        nsParts = lastIndex == 0 ? Collections.emptyList() :
            new UnmodifiableList<>(this.ids.subList(0, lastIndex));

        nameSpace = on('.').join(nsParts);
        key = on('.').join(ids);
    }

    public Fqn(String... ids) {
        this(asList(ids));
    }

    public List<String> getIds() {
        return ids;
    }

    public String getBase() {
        return base;
    }

    public List<String> getNsParts() {
        return nsParts;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public String getKey() {
        return key;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        Fqn fqn = (Fqn) o;
        return key.equals(fqn.key);
    }

    @Override public int hashCode() { return key.hashCode(); }

    @Override public String toString() { return key;}
}
