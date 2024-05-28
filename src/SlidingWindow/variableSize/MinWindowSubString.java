class MinWindowSubString {

    /**
     * 
     * Goal is to find the minium window in string s which contains all the characters of the given string t
     * 
     * The following similar strategy is also used in count of anagrams.
     * We use a map of character count.
     * we use a count variable to get the map.size() that indicates the number of unique characters in t
     * 
     * as we see a char at j, we subtract tha map[j] count.
     *  now if the map[j] count becomes zero, it means all that charatcer is exhausted and we decrement the count.
     */
    public String minWindow(String s, String t) {
       //create map of count of characters
       Map<Character,Integer> characterCount = new HashMap<Character,Integer>();
       countCharacters(characterCount,t);

        //get count of distinct characters 
       int count = characterCount.size();
       int min = Integer.MAX_VALUE;
       String result="";

       int i=0;
       int j=0;

       while(j<s.length()){

        //include operation
        char currCharAtJ = s.charAt(j);
        if(characterCount.containsKey(currCharAtJ)){
            characterCount.put(currCharAtJ,characterCount.get(currCharAtJ)-1); // Note the values can be negative as well. It just means that there are extra characters that does not break the condition. This can be optimised by removing those extra characters in the next step below
            if(characterCount.get(currCharAtJ)==0) count--; 
        }

        if(count>0){
            j++;
        }
        //this problem doesnt actually fit into this template. but it fits somewhat the template of fixed size window

        // if count is zero, this means the window has all the necessary characters. 
        else if(count==0){
            //now this is a possible candidate. But we want minimum, so we will see if this candidate can become smaller by maintaining the condition

            while(count==0){

                // consider the candidate
                if(j-i+1 < min){
                    min = j-i+1;
                    result = s.substring(i,j+1);
                }

                //optimise and check again
                // we optimise by removeing all the extra characters from the start of the window. Extra characters can be removed by ensuring that the overall count is still zero.
                char currCharAtI = s.charAt(i);
                if(characterCount.containsKey(currCharAtI)){
                    characterCount.put(currCharAtI,characterCount.get(currCharAtI)+1);
                    if(characterCount.get(currCharAtI)==1) count++;
                } 
                
                i++;
            }
            
            j++;
        }
       }

    return result;
    }

    public void countCharacters(Map<Character,Integer> map, String str){
        for(Character c : str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
    }
}