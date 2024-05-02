class PrintPowerSets
{

    public void solve(String input, String output, ArrayList<String> powerSets){
        if(input.length()==0){
            if(output.length()>0)
                powerSets.add(output);
            return;
        }
        String smallerInput = new StringBuilder(input).deleteCharAt(0).toString();
        String outputExcluded = output;//solve(smallerInput,output);
        String outputIncluded = output + input.charAt(0);//solve(smallerInput,String.valueOf(input.charAt(0)));
        
        solve(smallerInput, outputExcluded, powerSets);
        solve(smallerInput, outputIncluded, powerSets);
    }
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        ArrayList<String> powerSets = new ArrayList<String>();
        solve(s,"",powerSets);
        Collections.sort(powerSets);
        return powerSets;
    }
}