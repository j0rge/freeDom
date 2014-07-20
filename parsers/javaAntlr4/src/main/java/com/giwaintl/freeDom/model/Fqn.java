package com.giwaintl.freeDom.model;

import org.apache.commons.collections4.list.UnmodifiableList;

import java.util.List;

import static com.google.common.base.Joiner.on;

/**
 * Fully qualified name
 * @author Jorge U
 */
public class Fqn {
    private final UnmodifiableList<String> ids;

    private final String base;

    private final UnmodifiableList<String> nsParts;
    private final String nameSpace;

    private final String key;

    public Fqn(List<String> ids) {
        this.ids = new UnmodifiableList<>(ids);
        final int lastIndex = ids.size() - 1;
        base = ids.get(lastIndex);
        nsParts = new UnmodifiableList<>(ids.subList(0, lastIndex));
        nameSpace = on('.').join(nsParts);
        key = on('.').join(ids);
    }

    public List<String> getIds() {
        return ids;
    }

    public String getBase() {
        return base;
    }

    public UnmodifiableList<String> getNsParts() {
        return nsParts;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public String getKey() {
        return key;
    }
}
