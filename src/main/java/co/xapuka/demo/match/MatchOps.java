package co.xapuka.demo.match;

import java.util.function.Predicate;
public interface MatchOps<T> {
    boolean withAnyOf(T... possibleValues);
}
