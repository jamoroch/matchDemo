package co.xapuka.demo.match;

import java.util.Objects;
import java.util.stream.Stream;

 final class MatchWithIdentity<T> implements MatchOps<T> {

    private final T value;

    MatchWithIdentity(T value) {
        this.value = value;
    }

    @SafeVarargs
    public final boolean withAnyOf(T... possibleValues) {
        if (value == null) {
            return false;
        }
        return Stream.of(possibleValues).filter(Objects::nonNull).anyMatch(x -> value == x);
    }
}
