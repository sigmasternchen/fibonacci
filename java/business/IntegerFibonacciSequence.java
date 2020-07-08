package business;

public class IntegerFibonacciSequence extends AbstractFibonacciSequence<Integer> {
    @Override
    protected Integer add(Integer v1, Integer v2) {
        return v1 + v2;
    }

    public IntegerFibonacciSequence(Integer value1, Integer value2) {
        super(value1, value2);
    }
}
