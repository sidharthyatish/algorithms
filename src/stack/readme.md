# Stack problem identification

## identification - 1
When a problem is given in array, high chances of stack related question

## identification - 2
- It will mostly be an `O(n^2)` solution
- However the `n^2` like this might not be stack
  - `for(i=0;i<n,i++){ for(j=0;j<n;j++) }` where `j` is independent of `i`
- When `j` is dependent of `i` it might be stack
  - `for(i=0;i<n;i++)`
    - Having `j` such that
      - `j=0 to j=i, j++`
      - `j=i to j=0, j--`
      - `j=i to j=n, j++`
      - `j=n to j=i, j--`
  - In such cases we can be almost sure that its a stack problem 