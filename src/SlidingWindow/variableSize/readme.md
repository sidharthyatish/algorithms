# Variable size sliding window
Unlike fixed size, here we cannot maintain the size, rather we have to maintain the condition. 

## General format
```
i=0
j=0
while(j<length){
    condition = calculation.add(i);

    //condition not met, increase the window size
    if(condition<k){
        j++;
    }
    else if(condition == k){
        answer = max/min(condition,answer)
        j++; //increase the window further. the next element might also satisfy the condition ^
        
    }
    else if(condition > k){
        while(condition>k){
            condition = calculation.remove(i)
            i++;
        }
        j++; //increase the window for the next element to be processed in upcoming iteration. ^^
    }
}
```
Note:  
^ size we are increasing the window size even though the condition is met. That is the reason why the window size reduction is done in loop. Because despite satisfying condition, the window is growing, so it needs to be reduced in loop until its under the condition.
^^ this is important... else in next iteration we will come to the same condition as previous else if block

