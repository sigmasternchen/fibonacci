#!/bin/sh

fibonacci() {
	i="$1"
	if test "$i" = 0; then
		cat
		return 0
	fi

	(tee /dev/stderr | tail -n 2 | awk '{s += $1} END {print s}') 2>&1 | fibonacci $((i - 1))
}

fibonacci 5 <<EOF
1
1
EOF
