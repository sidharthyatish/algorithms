package Recursion;

public class SortArrayUsingRecursion {
    //insert an element with an array containing n-1 values already in it.
    public static void insertInAlreadySortedArray(int[] arr, int n, int elem){
        if(n==0 || elem > arr[n-1]){
            arr[n] = elem;
            return;
        }
        int lastElem = arr[n-1];
        insertInAlreadySortedArray(arr,n-1,elem);
        arr[n]=lastElem;
    }

    public static void sort(int[] arr, int n){
        if(n<=1) return;
        int lastElem = arr[n-1];
        //sort remaining elements
        sort(arr,n-1);
        //insert into the array of remaining elements. If its bigger element it will be any ways inserted in the last pos
        insertInAlreadySortedArray(arr,n-1,lastElem);
    }
    public static void main(String[] args) {
        //Testing insert on sorted array
        int sortedArray[] = {8,10,11,13,15,0}; //last element is zero to leave for the filling position
        insertInAlreadySortedArray(sortedArray,sortedArray.length-1,14);

        printArray(sortedArray);

        //Test sort method
        int arr[] = {3,2,6,4,5};
        sort(arr,arr.length);
        printArray(arr);



    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int elem : arr){
            System.out.print(elem+" ");
        }
        System.out.println("]");
    }
}
