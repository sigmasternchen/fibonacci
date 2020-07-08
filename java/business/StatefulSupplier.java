package business;

import java.util.function.Function;
import java.util.function.Supplier;

public interface StatefulSupplier<S, T> extends Supplier<T> {
    class StatefulSupplierImpl<S, T> implements  StatefulSupplier<S, T> {
        private S state;
        private Function<S, T> getter;

        private StatefulSupplierImpl(S state, Function<S, T> getter) {
            this.state = state;
            this.getter = getter;
        }

        @Override
        public T get(S s) {
            return getter.apply(s);
        }

        public T get() {
            return get(state);
        }
    }

    T get(S s);

    static <S, T> StatefulSupplier<S, T> get(S state, Function<S, T> getter) {
        return new StatefulSupplierImpl<>(state, getter);
    }
}
