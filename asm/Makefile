
all: fib32

fib32: fib32.asm
	nasm -f elf32 fib32.asm
	gcc -m32 -no-pie fib32.o -o $@
