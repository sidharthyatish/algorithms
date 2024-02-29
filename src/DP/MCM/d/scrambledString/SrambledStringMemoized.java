class ScrambledStringMemoized{

    //Since the changing params are strings, we use hashmap for dp
    static Map<String, Boolean> dp = new HashMap<>();
    static boolean solve(String a, String b)
    {
        String key = a + " " + b;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        
        if(a.equals(b)) return true;
        
        if(a.length() <= 1) return false;
        
        int n = a.length();


        boolean result = false;
        for(int k=1;k<=n-1;k++){
            
            boolean ifSwapped = solve(a.substring(0,k),b.substring(n-k,n)) &&
            solve(a.substring(k,n),b.substring(0,n-k));
            
            boolean ifNotSwapped = solve(a.substring(0,k),b.substring(0,k)) && solve(a.substring(k,n), b.substring(k,n));
            
           if(ifSwapped || ifNotSwapped){
               result = true;
               break;
           }
            
        }
        dp.put(key,result);
        
        return dp.get(key);
    }    
    static boolean isScramble(String S1,String S2)
    {
        //code here
        return solve(S1,S2);
     
        
    }
}