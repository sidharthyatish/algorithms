class Solution {
    public void solve(String output, int open, int close, List<String> list){
        if(open == 0 && close ==0){
            list.add(output);
            return;
        }
        if(open!=0){
            String outputWithOpenBracket = output + "(";
            solve(outputWithOpenBracket,open-1,close,list);
        }
        if(open<close){
            String outputWithCloseBracket = output+ ")";
            solve(outputWithCloseBracket,open,close-1,list);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> outputList = new ArrayList<String>();

        int open = n;
        int close =n;
        solve("",open,close,outputList);
        return outputList;

    }
}