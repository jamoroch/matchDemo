package co.xapuka.demo.match;

public class Match {

    private Match() {
    }

    public static <T> ObjectMatch it(T value) {
        return new ObjectMatch(value);
    }

}
