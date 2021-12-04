package co.xapuka.demo.match;

public interface WithAnyOf<T> {
    boolean withAnyOf(T... possibleValues);
}
