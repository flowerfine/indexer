package cn.sliew.indexer.common.util;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ProtostuffUtilTestCase {

    @Test
    public void testUtil() {
        User foo = new User("foo", 1);
        byte[] serialize = ProtostuffUtil.serialize(foo);
        User user = ProtostuffUtil.deserialize(serialize, User.class);
        assertNotNull(user);
        assertThat(user, hasProperty("id", equalTo(1)));
        assertThat(user, hasProperty("name", equalTo("foo")));
    }

    public static class User {
        private String name;
        private int id;

        public User(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
