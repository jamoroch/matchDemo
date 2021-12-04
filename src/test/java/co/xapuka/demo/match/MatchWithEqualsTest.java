package co.xapuka.demo.match;

import org.junit.jupiter.api.Test;

import static co.xapuka.demo.match.Task.TaskType.DIFFICULT;
import static co.xapuka.demo.match.Task.TaskType.IMPOSIBLE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchWithEqualsTest {

    @Test
    public void shouldMatchSameObject() {
        assertTrue(Match.usingEquals(new Task(42)).withAnyOf(new Task(42)));
    }

    @Test
    public void shouldMatch() {
        assertTrue(Match.usingEquals(42).withAnyOf(0, 42));
    }

    @Test
    public void shouldNotMatch() {
        assertFalse(Match.usingEquals("Juan").withAnyOf("Pablo"));
    }

    @Test
    public void shouldMatchEvenWithNull() {
        assertTrue(Match.usingEquals(56).withAnyOf(null, 56));
    }

    @Test
    public void shouldRejectNull() {
        assertFalse(Match.usingEquals(null).withAnyOf(null));
    }

    @Test
    public void shouldMatchEnums() {
        assertTrue(Match.usingEquals(IMPOSIBLE).withAnyOf(IMPOSIBLE));
    }

    @Test
    public void shouldNotMatchDifferentEnums() {
        assertFalse(Match.usingEquals(IMPOSIBLE).withAnyOf(DIFFICULT));
    }

}