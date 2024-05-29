class PermutationsRecursive{

    /*
    Print all permutations of a string. Permutations are different from subset that permutations are of same length of string

    Thus we branch for all the characters in a string. Leading to multiple branches which need to be called via loop.

    We use the same Ip/OP method of recursion.

    While branching, if there are duplicate chars we need to call the branch more than once. So we keep a set to check this..
    
    
     */
    public void solve(String input, String output, List<String> results){
        //Recursive solution
        if(input.length() ==0){
            results.add(output);
            return;
        }
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<input.length();i++){
            if(!set.contains(input.charAt(i))){ //avoid duplicate characters creating same set of permutations
                set.add(input.charAt(i));

                // We take each char at i and consider it for output.
                String newOutput = output+input.charAt(i);

                //THe new input is a combination of string before and after i.. [0...i-1]i[i+1...n] => new input = [0...i-1]+[i+1....n]
                String newInput = input.substring(0,i) + input.substring(i+1,input.length());
                solve(newInput,newOutput,results);
            }
           
        }
        
    }
    public List<String> find_permutation(String S) {
        // Code here
        List<String> results = new ArrayList<String>();
        
        solve(S,"",results);
        Collections.sort(results);
        return results;
    }
}