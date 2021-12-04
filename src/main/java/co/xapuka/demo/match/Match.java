package co.xapuka.demo.match;

public final class Match {

    private Match() {
    }

    public static <T> MatchOps<T> usingIdentity(T value) {
        return new MatchWithIdentity(value);
    }

    public static <T> MatchOps<T> usingEquals(T value) {
        return new MatchWithEquals(value);
    }

}
