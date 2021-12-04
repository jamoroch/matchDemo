package co.xapuka.demo.match;

import org.junit.jupiter.api.Test;

import static co.xapuka.demo.match.Task.TaskType.DIFFICULT;
import static co.xapuka.demo.match.Task.TaskType.IMPOSIBLE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchWithIdentityTest {

    @Test
    public void shouldRejectDifferentObjects() {
        assertFalse(Match.usingIdentity(new Task(42)).withAnyOf(new Task(42)));
    }

    @Test
    public void shouldMatch() {
        assertTrue(Match.usingIdentity(42).withAnyOf(0, 42, 1));
    }

    @Test
    public void shouldNotMatch() {
        assertFalse(Match.usingIdentity("Juan").withAnyOf("Pablo"));
    }

    @Test
    public void shouldMatchEvenWithNull() {
        assertTrue(Match.usingIdentity(56).withAnyOf(null, 56));
    }

    @Test
    public void shouldRejectNull() {
        assertFalse(Match.usingIdentity(null).withAnyOf(null));
    }

    @Test
    public void shouldNotMatchDifferentEnums() {
        assertFalse(Match.usingIdentity(IMPOSIBLE).withAnyOf(DIFFICULT));
    }
    @Test
    public void shouldMatchEnums() {
        assertTrue(Match.usingIdentity(IMPOSIBLE).withAnyOf(IMPOSIBLE));
    }

}