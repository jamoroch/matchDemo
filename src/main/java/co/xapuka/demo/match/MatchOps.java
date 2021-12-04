package co.xapuka.demo.match;

public interface MatchOps<T> {
    boolean withAnyOf(T... possibleValues);
}
