class LongestSubStringWithKUniqueChars {
    public int longestkSubstr(String s, int k) {
        // What is the condition here?
        // The condition is that the number of unique characters inside a window == k
        int i=0;
        int j=0;
        Map<Character,Integer> characterCount = new HashMap<Character,Integer>();
        int maxLength = -1;
        while(j<s.length()){
            //add operation
            Character currentChar = s.charAt(j);
            characterCount.put(currentChar,characterCount.getOrDefault(currentChar,0)+1);
            
            // condition not met
            if(characterCount.size()<k){
                j++;
            }
            
            //condition met
            else if(characterCount.size()==k){
                maxLength = Math.max(maxLength, j-i+1);
                j++;
            }
            
            //condition exceeds
            // Decrease the count of the characters. If the count becomes zero, remove it from the map. We want to maintain the map as size k.
            else if(characterCount.size()>k){
                while(characterCount.size()>k){
                    currentChar = s.charAt(i);
                    //remove operations
                    characterCount.put(currentChar,characterCount.getOrDefault(currentChar,0)-1);
                    if(characterCount.get(currentChar)<=0){
                        characterCount.remove(currentChar);
                    }
                    i++;
                }
                j++;
            }
            
        }
        return maxLength;
    }
}