package stack;

import java.util.Stack;

public class LargestAreaInBinaryMatrix
{
    /*
          0 1 1 0
          1 1 1 1
          1 1 1 1
          1 1 0 0
          
          In this the max area is the second and third row 1s 2*4 =8
          
          The above matrix can be split
          0 1 1 0 -> histogram with heights [ 0 1 1 0 ] --> (1)
          
          0 1 1 0
          1 1 1 1 -> histogram with heights [ 1 2 2 1 ] --> (2)
          
          0 1 1 0
          1 1 1 1
          1 1 1 1 -> histogram with heights [ 2 3 3 2 ] --> (3)
          
          0 1 1 0
          1 1 1 1
          1 1 1 1
          1 1 0 0 -> histogram with heights [ 3 4 0 0 ] --> (4)
                                                        Since the base is zero for last two columns
                                                        the histogram is floating and we consider the height starting
                                                        from base only
                                                        
          This we have four histograms (1), (2), (3), (4)
          Find the largest area for each histogram and return the max of all
     */
    
    //Helper. We are gonna call this for each row of histogram
    private int largestAreaInHistogram(int[] hist){
        int maxArea = Integer.MIN_VALUE;
        int currArea = 0;
    
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<hist.length;i++){
            while (!stack.isEmpty() && hist[i] <= hist[stack.peek()]){
                int popped = stack.pop();
                
                if(stack.isEmpty())
                    currArea = hist[popped] * i;
                else
                    currArea = hist[popped] * (i - stack.peek() -1);
                maxArea = Math.max(maxArea,currArea);
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()){
            int popped = stack.pop();
            if(stack.isEmpty())
                currArea = hist[popped] * hist.length;
            else
                currArea = hist[popped] * (hist.length - stack.peek() -1);
            maxArea = Math.max(maxArea,currArea);
        }
        return maxArea;
    }
    
    int largestAreaInBinaryMatrix(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        //For first row we can get result as such
        int maxArea = largestAreaInHistogram(matrix[0]);
        
        //For the next rows we need to add from previous rows
        for(int i=1;i<rows;i++){
            for(int j=0;j<columns;j++){
            
                if(matrix[i][j]==1)
                    matrix[i][j] = matrix[i][j] + matrix[i-1][j];
                //If it was zero we keep it as zero itself
            }
            int areaOfCurrRow = largestAreaInHistogram(matrix[i]);
            maxArea = Math.max(maxArea,areaOfCurrRow);
        }
        
        return maxArea;
    }
    
    public static void main(String[] args)
    {
        LargestAreaInBinaryMatrix binaryMatrix = new LargestAreaInBinaryMatrix();
        int[][] matrix = new int[][]{
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}};
    
        System.out.println(binaryMatrix.largestAreaInBinaryMatrix(matrix));
    }
}
