# Variable size sliding window
Unlike fixed size, here we cannot maintain the size, rather we have to maintain the condition. 

## General format (Aditya's)
This can be simplified a little to avoid repeated operations, especially the confusing j++ part
```
i=0
j=0
while(j<length){
    condition = calculation.add(j);

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
^^ this is important... else in next iteration we will come to the same condition as previous else if block. **THIS IS CONFUSING** follow the simplified format below

## Simplified general format
See the `j++` comes multiple times, we can take it outside, thus making the first condition irrelevant
```
i=0
j=0
while(j<length){
    condition = calculation.add(j);

    //condition met, increase the window size after getting an answer
    if(condition == k){
        answer = max/min(condition,answer);
        
    }
    //condition not met
    else {
        //condition not met could be smaller or greater. But if its smaller we dont have to do anything here
        while(condition>k){
            condition = calculation.remove(i);
            i++;
        }
    }

    j++; //taken the j++ common outside

}
```

