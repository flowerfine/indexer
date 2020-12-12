package cn.sliew.indexer.demo;

import cn.sliew.indexer.ApplicationTestCase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class DemoTestCase extends ApplicationTestCase {

    @Test
    public void test() throws Exception {
        assertThat("1", notNullValue());
    }
}
