WITH RECURSIVE fibonacci(i, n1, n2) AS (
	SELECT 
		0,
		1,
		1
	UNION ALL
	SELECT
		i + 1,
		n2,
		n1 + n2
	FROM fibonacci
	WHERE i < 8
)
SELECT n1 AS n FROM fibonacci
