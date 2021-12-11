package co.xapuka.demo.match;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

 final class MatchWithIdentity<T> implements MatchOps<T> {

    private final T value;


     MatchWithIdentity(T value) {
         this.value = value;
     }
     public static <T> Predicate<T> toPredicate(T... possibleValues) {
        return value -> Objects.nonNull(value) && Stream.of(possibleValues).filter(Objects::nonNull).anyMatch(x -> value == x);
     }

     @SafeVarargs
     public final boolean withAnyOf(T... possibleValues) {
        return toPredicate(possibleValues).test(value);
     }

 }
