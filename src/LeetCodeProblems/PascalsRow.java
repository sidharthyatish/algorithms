package LeetCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class PascalsRow
{
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int j=0;j<=rowIndex;j++){
            result.add(getPascalElement(rowIndex,j));
        }
    
        System.out.println(result);
        return result;
    }
    
    private int getPascalElement(int i,int j){
        if(j==0||j==i) return 1;
        return getPascalElement(i-1,j-1)+getPascalElement(i-1,j);
    }
    
    public static void main(String[] args)
    {
        PascalsRow pr = new PascalsRow();
        pr.getRow(3);
    }
}
