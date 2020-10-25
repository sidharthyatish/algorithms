package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class Point{
    int distFromOrigin;
    int x;
    int y;
    Point(int x,int y){
        
        this.x = x;
        this.y = y;
        
        //Distance formula is sqrt(sq(x2-x1)+sq(y2-y1))
        //Since it is origin it becomes sqrt(x2^2 + y2^2).
        //Since we are sorting, sqrt is not actually required
        this.distFromOrigin = this.x * this.x + this.y*this.y;
    }
}
public class KClosestPointsToOrigin
{
    void closestPoints(int[][] points, int k){
    
        //Create a maxHeap -> Sorted based on distance in desc order
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(new Comparator<Point>()
        {
            @Override
            public int compare(Point p1, Point p2)
            {
                return Integer.compare(p2.distFromOrigin,p1.distFromOrigin);
            }
        });
        
        int n = points.length;
        
        for(int i=0;i<n;i++){
            maxHeap.add(new Point(points[i][0],points[i][1]));
            if(maxHeap.size() > k )maxHeap.poll();
        }
        
        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.peek().x+" "+maxHeap.peek().y);
            maxHeap.poll();
        }
    }
    
    public static void main(String[] args)
    {
        int[][] arr = new int[][]{
                {3,3},{5,-1},{-2,4}
        };
        KClosestPointsToOrigin k = new KClosestPointsToOrigin();
        k.closestPoints(arr,2);
    }
}
