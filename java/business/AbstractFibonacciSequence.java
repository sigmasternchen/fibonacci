package business;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractFibonacciSequence<T> extends RecursiveSeqeunce<T> {
    private List<T> startValues = new ArrayList<>(2);

    protected abstract T add(T v1, T v2);

    public AbstractFibonacciSequence(T value1, T value2) {
        startValues.add(value1);
        startValues.add(value2);
    }

    @Override
    protected List<T> getInitialState() {
        return new ArrayList<>(startValues);
    }

    @Override
    protected T getNext(List<T> last) {
        return this.add(last.get(0), last.get(1));
    }

    public static <T> Consumer<T> prettyPrintConsumer(PrintStream stream, String format) {
        return RecursiveSeqeunce.accumulatedConsumer(3, l -> {
            stream.printf(format, l.get(0), l.get(1), l.get(2));
        });
    }
}
