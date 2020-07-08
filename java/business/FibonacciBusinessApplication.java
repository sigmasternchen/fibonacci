package business;

public class FibonacciBusinessApplication {
    public static void main(String[] args) {
        System.out.printf("Result: %d\n",
        new IntegerFibonacciSequence(1, 1)
            .stream()
            .limit(5)
            .peek(
                    AbstractFibonacciSequence.prettyPrintConsumer(
                            System.out,
                            "%d + %d = %d\n"
                    )
            ).mapToInt(Integer::intValue)
            .max()
            .getAsInt());
    }
}