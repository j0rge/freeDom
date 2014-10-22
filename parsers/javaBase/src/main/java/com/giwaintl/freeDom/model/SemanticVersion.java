package com.giwaintl.freeDom.model;

import static java.lang.String.valueOf;

/**
 * @author Jorge U
 */
public class SemanticVersion extends FreeformVersion {
    private final int maj;

    private final int min;
    private final int upd;

    public SemanticVersion(final int maj, final int min, final int upd) {
        super(valueOf(maj) + '.' + valueOf(min) + '.' + valueOf(upd));
        this.maj = maj;
        this.min = min;
        this.upd = upd;
    }

    public int getMaj() { return maj; }

    public int getMin() { return min; }

    public int getUpd() { return upd; }
}
