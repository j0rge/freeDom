package test.giwaintl.freeDom.parser;

import com.giwaintl.freeDom.model.Fqn;
import com.giwaintl.freeDom.model.type.DomEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 */
public class TestModel {
    private static final Logger L = getLogger(TestModel.class);

    @Before public void init() throws Exception { } @After public void destroy() throws Exception { }

    @Test public void testEnums() {
        DomEnum de = DomEnum.buildFrom(new Fqn("com", "blah", "meh", "Colors"), asList("Red", "White", "Blue"));
        assertThat(de.getName().getKey(), is("com.blah.meh.Colors"));
        assertThat(de.name(0), is("Red"));
        assertThat(de.name(1), is("White"));
        assertThat(de.name(2), is("Blue"));
        assertThat(de.ord("Red"), is(0));
        assertThat(de.ord("White"), is(1));
        assertThat(de.ord("Blue"), is(2));
        assertThat(de.names(), is(asList("Red", "White", "Blue")));
    }

    @Test public void testFqn() {
        final List<String> fqn1Src = asList("SingleName");
        final Fqn fqn1a = new Fqn("SingleName");
        final Fqn fqn1b = new Fqn(fqn1Src);
        L.info("Constructed 1 part FQN {}:key = {}, ns={}, base={} ", fqn1a, fqn1a.getKey(), fqn1a.getNameSpace(), fqn1a.getBase());
        assertThat(fqn1a, is(fqn1b));
        assertThat(fqn1a.getKey(), is("SingleName"));
        assertThat(fqn1b.getKey(), is("SingleName"));
        assertThat(fqn1a.getBase(), is("SingleName"));
        assertThat(fqn1a.getNameSpace(), is(""));

        final List<String> fqn2Src = asList("two", "PartsName");
        final Fqn fqn2a = new Fqn("two", "PartsName");
        final Fqn fqn2b = new Fqn(fqn2Src);
        assertThat(fqn2a, is(fqn2b));
        assertThat(fqn2a.getKey(), is("two.PartsName"));
        assertThat(fqn2b.getKey(), is("two.PartsName"));
        assertThat(fqn2a.getBase(), is("PartsName"));
        assertThat(fqn2a.getNameSpace(), is("two"));

        final List<String> fqn3Src = asList("two", "plus", "ParzzName");
        final Fqn fqn3a = new Fqn("two", "plus", "ParzzName");
        final Fqn fqn3b = new Fqn(fqn3Src);
        L.info("Constructed 3 part FQN {}:key = {}, ns={}, base={} ", fqn3a, fqn3a.getKey(), fqn3a.getNameSpace(), fqn3a.getBase());
        assertThat(fqn3a, is(fqn3b));
        assertThat(fqn3a.getKey(), is("two.plus.ParzzName"));
        assertThat(fqn3b.getKey(), is("two.plus.ParzzName"));
        assertThat(fqn3a.getBase(), is("ParzzName"));
        assertThat(fqn3a.getNameSpace(), is("two.plus"));
    }

}
