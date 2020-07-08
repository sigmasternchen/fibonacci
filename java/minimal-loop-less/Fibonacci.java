import java.util.Map;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.printf("Result: %d\n",
                Stream.iterate(
                        Map.entry(1, 1), e -> Map.entry(e.getValue(), e.getKey() + e.getValue())
                ).limit(args.length == 1 ? Integer.valueOf(args[0]) : 3
                ).peek(e -> System.out.printf("%d + %d = ", e.getKey(), e.getValue())
                ).mapToInt(e -> e.getKey() + e.getValue()
                ).peek(System.out::println
                ).max(
                ).getAsInt()
        );
    }
}