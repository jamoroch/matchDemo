package co.xapuka.demo.utils;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Utils {

    private Utils() {
    }

    public static <T> void setAfterBuild(Consumer<T> setter, Supplier<T> supplier) {
        setter.accept(supplier.get());
    }

    public static <T> void setIfOrThrow(Consumer<T> setter, Supplier<T> supplier, Predicate<T> predicate, Supplier<? extends RuntimeException> error) {
        T get;
        if(predicate.test(get = supplier.get())) {
            setter.accept(get);
        } else {
            throw error.get();
        }
    }

}