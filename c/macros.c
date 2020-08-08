/*
 * This file uses C macros to generate the fibonacci sequence.
 *
 * Run with:
 * gcc -E -P macros.c | sed 's/\\n /\n/g'
 */

#define FIRST(a, ...) a
#define SECOND(a, b, ...) b

#define IS_PROBE(...) SECOND(__VA_ARGS__, 0)
#define PROBE() ~, 1

#define CAT(a, b) a ## b

#define NOT(x) IS_PROBE(CAT(_NOT_, x))
#define _NOT_0 PROBE()

#define BOOL(x) NOT(NOT(x))

#define IF_ELSE(condition) _IF_ELSE(BOOL(condition))
#define _IF_ELSE(condition) CAT(_IF_, condition)

#define _IF_1(...) __VA_ARGS__ _IF_1_ELSE
#define _IF_0(...)             _IF_0_ELSE
#define _IF_1_ELSE(...)
#define _IF_0_ELSE(...) __VA_ARGS__

#define EMPTY()

#define DEFER1(m) m EMPTY()
#define DEFER2(m) m EMPTY EMPTY()()

#define EVAL(...) EVAL1024(__VA_ARGS__)
#define EVAL1024(...) EVAL512(EVAL512(__VA_ARGS__))
#define EVAL512(...) EVAL256(EVAL256(__VA_ARGS__))
#define EVAL256(...) EVAL128(EVAL128(__VA_ARGS__))
#define EVAL128(...) EVAL64(EVAL64(__VA_ARGS__))
#define EVAL64(...) EVAL32(EVAL32(__VA_ARGS__))
#define EVAL32(...) EVAL16(EVAL16(__VA_ARGS__))
#define EVAL16(...) EVAL8(EVAL8(__VA_ARGS__))
#define EVAL8(...) EVAL4(EVAL4(__VA_ARGS__))
#define EVAL4(...) EVAL2(EVAL2(__VA_ARGS__))
#define EVAL2(...) EVAL1(EVAL1(__VA_ARGS__))
#define EVAL1(...) __VA_ARGS__

#define HAS_ARGS(...) BOOL(FIRST(_END_OF_ARGUMENTS_ __VA_ARGS__)())
#define _END_OF_ARGUMENTS_() 0

#define INC(a) CAT(a, I)

#define ADD(a, b) a ## b

#define ZERO
#define ONE INC(ZERO)

#define FIB(a, b, i, ...) a + b = ADD(a, b)\
IF_ELSE(HAS_ARGS(__VA_ARGS__))(\
\n \
DEFER2(_FIB)()(b, ADD(a, b), __VA_ARGS__)\
)(\
	/* ignore */\
)
#define _FIB() FIB

EVAL(FIB(ONE, ONE, 1,2,3,4,5))
