package co.xapuka.demo.match;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

 final class MatchWithEquals<T> implements MatchOps<T> {

    private final T value;

     MatchWithEquals(T value) {
        this.value = value;
    }

     public static <T> Predicate<T> toPredicate(T[] possibleValues) {
         return value -> Objects.nonNull(value) && Stream.of(possibleValues).filter(Objects::nonNull).anyMatch(value::equals);
     }

     @Override
    @SafeVarargs
    public final boolean withAnyOf(T... possibleValues) {
        return toPredicate(possibleValues).test(value);
    }
}
