#!/usr/bin/awk -f
BEGIN {
	n  = 5;
	l1 = 0;
	l2 = 0;
}
{
	l1 = l2;
	l2 = $1;
	print l2;
}
END {
	for ( i = 0; i < n; i++ ) {
		l3 = l1 + l2;
		print l1 " + " l2 " = " l3;
		l1 = l2;
		l2 = l3;
	}
}
