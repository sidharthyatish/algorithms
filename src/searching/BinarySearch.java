package searching;

public class BinarySearch
{
    private int binarySearchIterative(int element, int[] arr){
        int min=0;
        int max = arr.length-1;
        while(min<=max){
            int mid  = (min+max)/2;
            if(arr[mid]==element) return mid;
            else if(element<arr[mid]) max=mid-1;
            else min = mid+1;
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        BinarySearch bs = new BinarySearch();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int elem =1;
        System.out.println(String.format("Position where element %s is found is : %s", elem,bs.binarySearchIterative(elem,arr)));
    }
}
