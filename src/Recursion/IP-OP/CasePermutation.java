class Solution {
    public void solve(String input, String output, List<String> results) {
        if(input.isEmpty()){
            results.add(output);
            return;
        }

        char nextCharacter = input.charAt(0);

        String outputWithExistingCase = output+ nextCharacter;
        char changedCase = Character.isUpperCase(nextCharacter)? Character.toLowerCase(nextCharacter): Character.toUpperCase(nextCharacter);
        String outputWithOtherCase = output+ changedCase;
        String smallerInput = new StringBuilder(input).deleteCharAt(0).toString();
        solve(smallerInput,outputWithExistingCase,results);

        /* if a character(
                solve(smallerInput,changeCase)
                solve(smallerInput,dontChangeCase)
            else if a number
                solve(smallerInput,dontChange case)

            This is what I have combined here. But for readability u can use this conditions
        */
        if(!(nextCharacter - '0' >=0&& nextCharacter - '0' <=9))
            solve(smallerInput,outputWithOtherCase,results);
    }
    public List<String> letterCasePermutation(String s) {
        List<String> results = new ArrayList<String>();

        solve(s,"",results);
        return results;
    }
}