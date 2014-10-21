package com.giwaintl.freeDom.model;

/**
 * @author Jorge U
 */
public class JdkVersion extends SemanticVersion {
    int topmost; // should be a constant
    int major;
    int minor;
    int update;

    public JdkVersion(int maj, int min, int upd) {
        super(maj, min, upd);
    }
}
