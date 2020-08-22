section .text

global main
extern printf

fib:
	pop	ebx
	pop	ecx
	pop	eax
	pop	edx
	sub	esp, 12
	push	ebx

	cmp	ecx, 0
	je	fibend
		
fibloop:
	mov	ebx, eax
	add	ebx, edx

	push	ecx ; ecx is not callee-saved in the linux abi

	push	ebx
	push	edx
	push	eax
	push	format

	call	printf

	add	esp, 8
	pop	eax
	pop	edx

	pop	ecx

	dec	ecx
	jnz	fibloop
fibend:
	ret

main:
	mov	ebx, 1
	push	ebx
	push	ebx
	mov	ebx, 5
	push	ebx

	call	fib

	add	esp, 12

	mov	eax, 0 ; return 0
	ret

section .data
format:
	db '%d + %d = %d', 10, 0
