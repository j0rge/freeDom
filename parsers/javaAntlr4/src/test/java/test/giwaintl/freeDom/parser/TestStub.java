package test.giwaintl.freeDom.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestStub {

    private static Logger L = LoggerFactory.getLogger(TestStub.class);
    @Before public void init() throws Exception {
    }

    @After public void destroy() throws Exception {
    }

    @Test public void testSome() throws Exception {
        L.info("Tested");
    }
}
