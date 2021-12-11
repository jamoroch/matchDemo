package co.xapuka.demo.utils;

import org.junit.jupiter.api.Test;

import static co.xapuka.demo.utils.Utils.setAfterBuild;
import static co.xapuka.demo.utils.Utils.setIfOrThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilsTest {

    @Test
    public void testSetAfterBuild() {

        var bar = new Bar("bar4");

        setAfterBuild(bar::setMe, () -> "foo");

        assertEquals("bar4foo", bar.getBarFoo());
    }

    @Test
    public void testSetAndThrow() {
        var bar = new Bar("");
        assertThrows(RuntimeException.class,() -> setIfOrThrow(bar::setMe, () -> null, (x) -> x != null, () -> new RuntimeException("Test")));
    }

    private static class Bar {
        private final String bar;
        private String barFoo;
        private Bar(String bar) {
            this.bar = bar;
        }


        public void setMe(String foo) {
            barFoo = bar + foo;
        }

        public String getBarFoo() {
            return barFoo;
        }
    }
}
