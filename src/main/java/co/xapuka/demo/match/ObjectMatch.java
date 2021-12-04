package co.xapuka.demo.match;

import java.util.Objects;
import java.util.stream.Stream;

public class ObjectMatch<T> implements WithAnyOf<T> {

    private final T value;

    ObjectMatch(T value) {
        this.value = value;
    }

    @Override
    public boolean withAnyOf(T... possibleValues) {
        if (null == value) {
            return false;
        }
        return Stream.of(possibleValues).filter(Objects::nonNull).anyMatch(x -> value == x);
    }
}
