class CountOfAnagrams{
    void countCharactersInString(Map<Character,Integer> map, String str){
        for(int i=0;i<str.length();i++){
            char character = str.charAt(i);
            map.put(character,map.getOrDefault(character,0)+1);
        }
    }

    int search(String pat, String txt) {
        // code here
        int anagramCount = 0;
        
        Map<Character,Integer> characterCount = new HashMap<Character,Integer>();
        
        countCharactersInString(characterCount, pat);
        int inputCharacterCount = characterCount.size();
        
        int i=0;
        int j=0;
        int k=pat.length();
        
        while(j<txt.length()){
            //include operation
            char charAtj = txt.charAt(j);
            if(characterCount.containsKey(charAtj)){
                //decrease count in character map
                characterCount.put(charAtj,characterCount.get(charAtj)-1);
                
                
                //check if count become zero from previously one, this means the character is used up to count. Any same character coming again cannot be an anagram now
                if(characterCount.get(charAtj)==0){
                    inputCharacterCount--;
                }
            }
            
            //window size not matched
            if(j-i+1<k){
                j++;
            }
            
            else if(j-i+1==k){
                //window size matched -> resultCalculation + exclude
                if(inputCharacterCount==0){
                    anagramCount++;
                }
                
                char charAtI = txt.charAt(i);
                if(characterCount.containsKey(charAtI)){
                    characterCount.put(charAtI,characterCount.get(charAtI)+1);
                    
                    //check if count become one from previous zero. 
                    // This means that the discarded character was in our pattern and we have it updated in map for next window. If the character comes up again in next window, its available to be counted as anagram
                    if(characterCount.get(charAtI)==1){
                        inputCharacterCount++;
                    }
                }
                //slide the window
                i++;
                j++;
            }
            
            
        }
        
        return anagramCount;
    }
}