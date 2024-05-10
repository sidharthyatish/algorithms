# Sliding window problems

## Identification
- Mentions subarray, substring, and possibly a window size which is given explicitly (static) or we might need to derive (dynamic)
- Also we need to find a min/max of all the sub arrays

### Concept
- Concept is that once we have a window, and have some calculations, for the next window, we can reuse the existing calculation
- Subarray of size k is validated by using `j-1+1 == k`

### Template for static window size
```
i=0
j=0
while(i<N){
    operation.add(arr[j]);  --> 1
     
     // if window size not met, just increase the window
    if(j-i+1<k){
        j++;
    }
    else if(j-i+1==k){
        perform_calculation_using_operation_so_far();
        
        operation.remove(arr[i]);  -->2
        
        // slide the window
        i++;
        j++;
        
    }
}

return result;
```
Note : (2) is reverse operation of (1) mostly but with i instead of j
