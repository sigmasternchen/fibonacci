package business;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface StatefulConsumer<S, T> extends Consumer<T> {
    class StatefulConsumerImpl<S, T> implements StatefulConsumer<S, T> {
        private S state;
        private BiConsumer<S, T> consumer;

        private StatefulConsumerImpl(S state, BiConsumer<S, T> consumer) {
            this.state = state;
            this.consumer = consumer;
        }

        @Override
        public void accept(S state, T value) {
            consumer.accept(state, value);
        }

        @Override
        public void accept(T t) {
            accept(state, t);
        }
    }

    void accept(S state, T value);

    static <S, T> StatefulConsumer<S, T> get(S state, BiConsumer<S, T> consumer) {
        return new StatefulConsumerImpl<>(state, consumer);
    }
}
