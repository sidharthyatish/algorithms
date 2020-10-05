package LeetCodeProblems;


import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGuards
{
    class Pair{
        int first;
        int second;
        Pair(int i, int j){
            this.first = i;
            this.second = j;
        }
    }
    
    int[][] updateMatrix(char[][] matrix){
        int N = matrix.length;
        int M = matrix[0].length;
        
        int[][] output = new int[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
            {
//                if(matrix[i][j]=='W')
//                    output[i][j] = -1;
//                else
                    output[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(matrix[i][j]=='G'){
                    output[i][j]=0;
                    bfs(matrix,output,i,j,N,M);
                }
            }
        }
        
        return output;
    }
    //Top(-1,0), left(0,-1), right(0,1), bottom(1,0)
    int[] iNeighBour = new int[]{-1,0,0,1};
    int[] jNeighbour = new int[]{0,-1,1,0};
    
    void bfs(char[][] matrix, int[][]output,int row,int column,int N, int M){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row,column));
        output[row][column]=0;
        int currentDistance = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            //current breadth
            currentDistance++;
            for(int it = 0;it <size;it++){
                Pair poppedElem = queue.poll();
                int i = poppedElem.first;
                int j= poppedElem.second;
                //neighbours
                for(int n=0;n<4;n++){
                    Pair neighbour = new Pair(i+iNeighBour[n],j+jNeighbour[n]);
                    if(isPairValid(neighbour.first,neighbour.second,N,M)&&
                            matrix[neighbour.first][neighbour.second]!='W'&&
                            matrix[neighbour.first][neighbour.second]!='G'&&
                            (output[neighbour.first][neighbour.second]>currentDistance)){
                        output[neighbour.first][neighbour.second]=currentDistance;
                        queue.add(neighbour);
                    }
                    else if(isPairValid(neighbour.first,neighbour.second,N,M)&&matrix[neighbour.first][neighbour.second]=='W'){
                        output[neighbour.first][neighbour.second] = -1;
                    }
                }
                
            }
            
            
        }
    }
    
    boolean isPairValid(int i,int j,int N,int M){
        return (i>=0&&i<N&&j>=0&&j<M);
    }
    
    
    public static void main(String[] args)
    {
        WallsAndGuards ws = new WallsAndGuards();
        char[][] matrix = new char[][]{
                {'O', 'O', 'O', 'O', 'G'},
                {'O', 'W', 'W', 'O', 'O'},
                {'O', 'O', 'O', 'W', 'O'},
                {'G', 'W', 'W', 'W', 'O'},
                {'O', 'O', 'O', 'O', 'G'}
        };
        char[][] matrix2 = new char[][]{
                {'O', 'W', 'G', 'O'},
                {'O', 'O', 'O', 'W'},
                {'O', 'W', 'O', 'W'},
                {'G', 'W', 'O', 'O'}
        };
        
        int[][] output = ws.updateMatrix(matrix);
        int[][] output2 = ws.updateMatrix(matrix2);
        System.out.println("Completed");
        for(int i =0;i<output2.length;i++){
            for(int j=0;j<output2[i].length;j++){
                System.out.print(output2[i][j]+" ");
            }
            System.out.println();
        }
    }
}
