++++ number of iterations
>
++++++++++ dec 10 = \n
>
++++++++++++++++++++++++++++++++++++++++++++++++ dec 48 = 0
+.
<.>
.-
<.
>>
+ value 1
>
+ value 2
<<<<
[ iterate
        -
        >>>
        [ copy value 1 to result
                -
                >>+
                <<
        ]
        >
        [ add value 2 to result and set value 1
                -
                >+
                <<
                +
                >
        ]
        >
        [ copy result to value 2 and to ascii
                -
                >+
                <<+
                >
        ]
        <<<
        [ calculate ascii value; use result for dec 30
                -
                >>>+
                >+
                <<<<
        ]
        >>>
        [ restore dec 30
                -
                <<<+
                >>>
        ]
        >.
        [ reset ascii
                -
        ]
        <<<<<.
        <
]
