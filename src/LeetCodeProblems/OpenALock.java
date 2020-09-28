package LeetCodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenALock
{
    public int numOfWaysToOpenALock(String[] deadEnds, String target){
        String start = "0000";
        int length=0;
        Set<String> deads = new HashSet<>();
        deads.addAll(Arrays.asList(deadEnds));
        //return (helper(deadEnds,start,visited,target));
    
//        visited.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        
        while (!queue.isEmpty()){
            int size = queue.size();
            length++;
            for(int i=0;i<size;i++){
                String poppedString = queue.poll();
//                System.out.println(poppedString);
                if(deads.contains(poppedString)) continue;
                if(poppedString.equals(target)) return length-1; //Why -1? as per the question, 0000 is not counted
                deads.add(poppedString);
                for(int j=0;j<4;j++){
                    String incString  = incrementAtPosition(poppedString,j);
//                    System.out.println(incString+" "+j);
                    String decString = decrementAtPosition(poppedString,j);
                    if(!deads.contains(incString)) queue.add(incString);
                    if(!deads.contains(decString)) queue.add(decString);
                }
                
            }
            
        }
        
        return -1;
        
    }
    
    String incrementAtPosition(String inputString, int pos){
        StringBuilder str = new StringBuilder(inputString);
        int numAtPosition = str.charAt(pos)-'0';
        numAtPosition = (numAtPosition+1)%10;
        str.setCharAt(pos,(char)(numAtPosition+'0'));
        return str.toString();
    }
    
    String decrementAtPosition(String inputString, int pos){
        StringBuilder str = new StringBuilder();
        str.append(inputString);
        int numAtPosition = str.charAt(pos)-'0';
        if(--numAtPosition<0) numAtPosition =9;
        str.setCharAt(pos,(char)(numAtPosition+'0'));
        return str.toString();
    }
    
    public static void main(String[] args)
    {
        OpenALock ol = new OpenALock();
        System.out.println(ol.numOfWaysToOpenALock(new String[]{"0000"},"8888"));
//        System.out.println(ol.incrementAtPosition("0001",0));
    }
}
