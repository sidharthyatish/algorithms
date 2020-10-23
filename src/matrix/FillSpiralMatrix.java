package matrix;

public class FillSpiralMatrix
{
    void fillMatrix(int n)
    {
        int[][] matrix = new int[n][n];
        
        int number = n * n;
        
        int iStart = 0;
        int jStart = 0;
        int iEnd = n - 1;
        int jEnd = n - 1;
        
        int rotation = n % 2 == 0 ? 2 : 0;
        
        
        while (iStart <= iEnd && jStart <= jEnd)
        {
            
            //top to bottom
            if (rotation == 0)
            {
                for (int i = iStart; i <= iEnd; i++)
                {
                    matrix[i][jStart] = number--;
                }
                jStart++;
            }
            
            //left to right
            else if (rotation == 1)
            {
                for (int j = jStart; j <= jEnd; j++)
                {
                    matrix[iEnd][j] = number--;
                }
                iEnd--;
            }
            
            //bottom to top
            else if (rotation == 2)
            {
                for (int i = iEnd; i >= iStart; i--)
                {
                    matrix[i][jEnd] = number--;
                }
                jEnd--;
            }
            
            //right to left
            else if (rotation == 3)
            {
                for (int j = jEnd; j >= jStart; j--)
                {
                    matrix[iStart][j] = number--;
                }
                iStart++;
            }
            rotation = (rotation + 1) % 4;
            
        }
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        FillSpiralMatrix fm = new FillSpiralMatrix();
        fm.fillMatrix(4);
    }
}
