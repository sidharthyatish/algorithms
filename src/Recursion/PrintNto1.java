package Recursion;

public class PrintNto1
{
    void print(int n){
        if(n==0) return; // Base condition
        System.out.println(n); //Induction
        print(n-1); //Hypothesis
    } 
    
    public static void main(String[] args)
    {
        new PrintNto1().print(5);
    }
}
