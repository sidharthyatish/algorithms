class LongestSubStringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {


        /** what is the condition here....
         * The condition is that the number of unique characters === the window size
         *  If not, it means that window has become bigger but unique characters are lesser, meaning the window contains duplicates
         *  So the 
         * <k condition === map size getting bigger than the window (redundant, will not happen at all. Just put here for the template)
         * ==k condition === map size is same as the window size (all are unique)
         * >k condition === map size smaller than window( duplicates present) 
         */
        int i=0;
        int j=0;
        int maxLength = 0;
        Map<Character,Integer> countMap = new HashMap<Character,Integer>();

        while(j<s.length()){
            Character current = s.charAt(j);
            countMap.put(current,countMap.getOrDefault(current,0)+1);
            int k = j-i+1;

            //This condition is redundant. Can be removed
            if(countMap.size()>j-i+1){
                j++;
            }
            else if(countMap.size() == j-i+1){
                maxLength = Math.max(maxLength, k);
                j++;
            }

            // Why < ? if the window > unique characters, then the window contains duplicates
            else if(countMap.size() < j-i+1){
                while(countMap.size() < j-i+1){
                    current = s.charAt(i);
                    int currentCount = countMap.getOrDefault(current,0);
                    countMap.put(current,currentCount-1);
                    if(countMap.get(current) ==0){
                        countMap.remove(current);
                    }
                    i++;
                }
                j++;
            }

        }
        return maxLength;
    }
}