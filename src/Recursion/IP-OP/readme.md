## Recursion - input output method

In this method we create something called decision tree with each node containing input-output pairs

### List all subsets

#### Problem statement
Print all the subsets for a given string/array
"abc" -> {"a","b","c","ab","bc","ac","abc}
#### Decision
The decision in each stage is to choose or not choose a character for printing.
e.g. I can choose a and take it to output or ignore it and go to the next character

#### Input-output
This is a pair which is like (OP-IP) / (IP-OP)
The OP starts with an empty string ""
The IP starts with the whole string "abc"
The pair looks like ("","abc")

#### Decision tree
                               (OP,IP)
                                ("","abc")
        ignore "a"           /             \      select "a"
                            /               \
                    ("","bc")                ("a","bc")
                    /       \                  /        \
          !"b"     /         \ "b"            /          \     decision for b
               ("","c")      ("b","c")       ("a","c")    ("ab","c")
              /     \        /      \         /     \         /     \      decisions for c
             /       \      /        \       /       \       /       \
            "","" "c",""  "b","" "bc","" "a",""  "ac",""  "ab",""  "abc",""   

Note that the output is when input becomes empty
        