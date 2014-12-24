package com.giwaintl.freeDom.model.type;

import com.giwaintl.freeDom.model.Fqn;

/**
 * Ancestor for all Dom objects: enums, structs and whatever we will implement later
 */
public class DomObjectType implements FreeDomType {
    private final Fqn name;

    public DomObjectType(Fqn name) {
        this.name = name;
    }

    public Fqn getName() {
        return name;
    }
}
