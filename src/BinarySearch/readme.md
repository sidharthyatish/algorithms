## Binary search identification and general format
Usually if the problems involve sorted or sorted + rotated then it can be solved using binary search

### General format
- Given a sorted array, you calculate the mid
- Now you have to discard the sub array to the left / right of the mid (1) 
- Also, you have to find an element/index with some condition. - (2) 
  - Sometimes, it might be to search for a given element, or an element/index that meets a criteria
  - We might have to figure out the criteria by looking into the subarray + target element combination (e.g., smallest, largest)
- This decision to discard (1) + the criteria to choose the target (2) together defines the solution needed
