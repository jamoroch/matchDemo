package co.xapuka.demo.match;

import java.util.function.Predicate;

public final class Match {

    private Match() {
    }

    public static <T> MatchOps<T> usingIdentity(T value) {
        return new MatchWithIdentity(value);
    }

    public static <T> MatchOps<T> usingEquals(T value) {
        return new MatchWithEquals(value);
    }

    public static <T> Predicate<T> theseUsingIdentity(T... possibleValues) {
        return MatchWithIdentity.toPredicate(possibleValues);
    }

    public static <T> Predicate<T> theseUsingEquals(T... possibleValues) {
        return MatchWithEquals.toPredicate(possibleValues);
    }
}
