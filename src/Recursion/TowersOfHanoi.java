class TowersOfHanoi {
    
    static int count;
    public static void print(int diskNumber, int sourceRod, int destRod){
        System.out.println("move disk "+diskNumber+" from rod "+sourceRod+" to rod "+destRod);
    }
    //Note : for counting we are incrementing count only where print statements are. Print statement == move

    public static void towerOfHanoi(int N, int from, int to, int aux){
        if(N==1){
            print(N,from,to);
            count++;
            return;
        }
        
        towerOfHanoi(N-1,from,aux,to);
        print(N,from,to);
        count++;
        towerOfHanoi(N-1,aux,to,from);
    }

    public long toh(int N, int from, int to, int aux) {
        count = 0;
        // Your code here
        new TowersOfHanoi().towerOfHanoi(N,from,to,aux);
        return count;
        
    }
}