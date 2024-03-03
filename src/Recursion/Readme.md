# How to solve a problem recursively

## Steps
- Induction
- Base condition
- Hypothesis

### Hypothesis
- I assume my function definitely works
- `print(n)` will definitely print number from n to 1
- This means for any value k, `print(k)` works, then for next value k+1 `print(k+1)` also works for sure

### Base condition
- My function has at least one input condition for which the input doesnt become further small
- For a base condition my function either returns a single value or just returns without doing anything

### Induction
- This is where I make sure my hypothesis is working as expected
- This is writing the additional logic
- ``` 
  void print(n){
  if(n==0) return; (Base condition)
  System.out.println(n); //My induction, the working code
  print(n-1); //Input is smaller than before now (I trust my hypothesis)
  }

```