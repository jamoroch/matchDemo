package co.xapuka.demo.match;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchTest {

    @Test
    public void shouldMatch() {
        assertTrue(Match.it(42).withAnyOf(0, 42, 1));
    }

    @Test
    public void shouldNotMatch() {
        assertFalse(Match.it("Juan").withAnyOf("Pablo"));
    }

    @Test
    public void shouldMatchEvenWithNull() {
        assertTrue(Match.it(56).withAnyOf(null, 56));
    }

    @Test
    public void shouldRejectNull() {
        assertFalse(Match.it(null).withAnyOf(null));
    }

}