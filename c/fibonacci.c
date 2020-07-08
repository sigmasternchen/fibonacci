#include <stdio.h>
#include <stdlib.h>

 int fibonacci(int a, int b, int limit, void (*forEach)(int, int, int)) {
	if (limit == 0)
		return b;
		
	int c = a + b;
	forEach(a, b, c);
	return fibonacci(b, c, limit - 1, forEach);
}

void printIteration(int a, int b, int c) {
	printf("%d + %d = %d\n", a, b, c);
}

int main(int argc, char** argv) {
	int limit = 3;
	if (argc > 1)
		limit = atoi(argv[1]);
	
	int result = fibonacci(1, 1, limit, printIteration);
	printf("Result: %d\n", result);
	
	return 0;
}
