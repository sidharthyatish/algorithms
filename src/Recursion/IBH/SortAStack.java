package Recursion;

import java.util.Stack;

public class SortAStack {
    
    //Check sort array using recursion before this
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        System.out.println(stack);
        sort(stack);
        System.out.println(stack);
    }

    private static void sort(Stack<Integer> stack) {
        if(stack.size() <=1 ) return;

        int topElement = stack.pop();
        sort(stack);
        insertElementInSortedStack(stack, topElement);

    }

    private static void insertElementInSortedStack(Stack<Integer> stack, int element) {
        if(stack.isEmpty()||element > stack.peek()){
            stack.push(element);
            return;
        }

        int topElementInStack = stack.pop();
        insertElementInSortedStack(stack,element);
        stack.push(topElementInStack);

    }
}
