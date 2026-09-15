## Binary search identification and general format

### Identification
- Sorted, or sorted + rotated array
- Array not sorted, but a question about `mid` and its neighbours has a yes/no answer that flips only once (peak, rotation point)
- "Find the minimum/maximum X such that <check> passes" and a bigger X never makes the check fail (capacity to ship, koko)
  - Here there is no array. Imagine one: index = X, value = check(X)

### Concept
- Binary search = ask `mid` one question. The answer must kill half the array
- Sorted is NOT the requirement. The requirement is that the answer to my question looks like this across the array

[ F F F F F T T T T T ]
^ I am hunting this flip

- Sorted arrays just happen to give this for the question `arr[mid] >= x`

### Three decisions define the solution
- (1) What question do I ask at `mid`
- (2) Which half does the answer let me discard
- (3) Do I `return mid` right there, or do I `res = mid` and keep going

### General format

```
low = 0
high = n-1
res = -1 (or a sensible default)

while(low<=high){
mid = low + (high-low)/2;
  if(found exactly at mid) return mid;          --> shape A only

  else if(answer lies to the left){
      res = mid;   --> shape B only. mid is a candidate, but a better one might be further left
      high = mid-1;
  }
  else{
      res = mid;   --> shape B only, if the better one might be further right
      low = mid+1;
  }
}
return res;
```


### Shape A - find THE element
- Only one right answer. When I see it, I am done. `return mid`
- No `res` needed
- e.g. classic search, reverse sorted, order unknown, nearly sorted, infinite array, rotated array (once pivot is known)

### Shape B - find a BOUNDARY
- Problem says first / last / smallest / largest / floor / ceil / minimum / "such that" --> shape B
- When mid satisfies the condition, it is only a candidate. Why? A better candidate may be further on one side

{ 1 2 2 2 2 3 } find first 2
^ mid is a 2. But is it the FIRST 2? Don't know. Save it, go left.

- So `res = mid` and squeeze toward the better side. Return `res` after the loop
- Floor and ceil are mirror images. Floor saves and goes right, ceil saves and goes left
- Binary search on the answer (ship capacity, koko) is just CEIL on the imaginary array

capacity : lo .......................... hi
days<=D : F F F F T T T T T T T
^ smallest capacity that works = first T = ceil


### Problem map (shape, question at mid, where to squeeze)
- BinarySearch                --> A, `arr[mid]==x`
- Reverse / order unknown     --> A, same, swap the two branches using a flag `arr[low] < arr[high]`
- SearchInNearlySorted        --> A, check mid-1, mid, mid+1 together, then jump by 2
- SearchInInfinite            --> A, first double `high` until `arr[high] > x`, then classic
- FindElementInRotated        --> A, find pivot (which is shape B), then classic on the correct sorted half
- FirstOccurrence             --> B, `arr[mid]==x` is a candidate, go left
- LastOccurrence              --> B, `arr[mid]==x` is a candidate, go right
- Floor                       --> B, `arr[mid]<x` is a candidate, go right (want the largest small one)
- Ceil / SearchInsert         --> B, `arr[mid]>x` is a candidate, go left (want the smallest big one)
- NextAlphabeticalElement     --> B, ceil with the `==` branch removed
- MinDiffElement              --> classic search. When it fails, `high` sits on floor and `low` sits on ceil. Pick the closer
- NumberOfTimesRotated        --> B, `arr[mid]<=arr[mid-1]` means mid is the smallest. Else discard the SORTED half
- PeakElement                 --> B, `arr[mid-1]<arr[mid]` means I am climbing, peak is to the right. Else left
- CapacityToShip              --> B, `daysTaken(mid)<=D` is a candidate, go left (want smallest capacity)
- RowColSortedMatrix          --> NOT binary search. Staircase from top right corner, O(m+n)

### Notes
- Always `while(low<=high)`. The `=` handles single element and the last comparison
- `mid = low + (high-low)/2` and not `(low+high)/2`. Why? overflow
- When a classic search fails, `low` and `high` have crossed. `high` = floor of x, `low` = ceil of x. Always
- Rotation and Peak never look at sortedness. They ask about mid's neighbours. The answer still flips only once
- Search on the answer: `low` = smallest possible answer, `high` = largest possible answer. Not indices
  - Reading `arr[mid]` costs O(n) here (it is a function call). Total O(n log(high-low))