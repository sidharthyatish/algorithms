class SearchInRowColSortedMatrix{

    /* 
    10 20 30 40
    12 15 18 21
    24 29 31 35
    45 55 65 70

    Note, all elements below an element are greater, to the left its smaller. This would be our direction of traversal
    O(m+n)

    if I want to search for 29, i start with top right corner

    if that arr[i][j] > x, then the whole column is useless, so we go to left side column
    if that arr[i][j] < x, then we go to the bottom row, 
    
    
    */
    static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    // code here 
	    int i=0;
	    int j=m-1;
	    while(i>=0 && i<=n-1 && j>=0 && j<=m-1){
	        if(matrix[i][j] ==x) return true;
	        if(matrix[i][j] > x) j--;
	        else i++;
	    }
	    return false;
	} 
}