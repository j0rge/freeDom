package com.giwaintl.freeDom.model.type;

import com.giwaintl.freeDom.model.Fqn;

/**
 * Ancestor for all Dom objects: enums, structs and whatever we will implement later
 */
public class DomObject {
    private final Fqn name;

    public DomObject(Fqn name) {
        this.name = name;
    }

    public Fqn getName() {
        return name;
    }
}
