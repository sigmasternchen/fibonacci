package business;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public abstract class RecursiveSeqeunce<T> implements Sequence<T> {

    protected abstract List<T> getInitialState();
    protected abstract T getNext(List<T> last);

    private T supplierGetter(Couple<Integer, List<T>> _state) {
        List<T> state = _state.getV2();
        int size = state.size();
        int index = _state.getV1();

        _state.setV1(index + 1);

        if (index < size) {
            return state.get(index);
        }

        T value = getNext(state);

        state.remove(0);
        state.add(value);

        return value;
    }

    @Override
    public Stream<T> stream() {
        return Stream.generate(StatefulSupplier.get(new Couple<>(0, getInitialState()), this::supplierGetter));
    }

    public static <T> Consumer<T> accumulatedConsumer(int recursionLength, Consumer<List<T>> consumer) {
        return StatefulConsumer.get(new ArrayList<T>(recursionLength), (l, o) -> {
            if (l.size() >= recursionLength) {
                l.remove(0);
            }
            l.add(o);

            if (l.size() >= recursionLength) {
                consumer.accept(l);
            }
        });
    }
}
