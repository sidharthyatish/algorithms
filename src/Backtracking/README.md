# Backtracking

## What is this
- Backtracking = controlled recursion + pass by reference
- Controlled recursion => Choices would be large so we have to control the choices to which we will call recursion
- Pass by reference => So that changes in one node is available in the parent
- DP = recursion + memory => the result is available in root
- Recursion => the result is available in the leaf
- BT = the result is available across path
- Dont be greedy. Greedily solving i.e., choosing the best possible solution in every step might result in incorrect answer

## Identification
- All possible paths/solutions would be asked
- Constraints would be very large (maybe in exponential)

## General format
- Parent is recursion. So this will be solved recursively
```
void function(String input){ //should be pass by reference

//Base condition would not be simple. It would be another function

    if(isSolve(input)==true){
        output;
        return;
    }

    //Since the choices are multiple, `function(input1), function(input2), ...`, we will loop the calls

    for(c in choices..){
        if(isValid(c)){ //controlling recursion
            makeChanges(c); //make the necessary changes to input
            function(c);
            undoChanges(c); //revert the made changes from the previous recursive call since its pass by reference

        }
    }
}
```
