package business;

import java.util.stream.Stream;

public interface Sequence<T> {
    Stream<T> stream();
}
