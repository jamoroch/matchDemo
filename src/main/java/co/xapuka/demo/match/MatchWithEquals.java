package co.xapuka.demo.match;

import java.util.Objects;
import java.util.stream.Stream;

 final class MatchWithEquals<T> implements MatchOps<T> {

    private final T value;

     MatchWithEquals(T value) {
        this.value = value;
    }

    @Override
    @SafeVarargs
    public final boolean withAnyOf(T... possibleValues) {
        if (value == null) {
            return false;
        }
        return Stream.of(possibleValues).filter(Objects::nonNull).anyMatch(value::equals);
    }
}
