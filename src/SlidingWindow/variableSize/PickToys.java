class PickToys{
    // same as https://leetcode.com/problems/fruit-into-baskets/

    // Here the problem is that its to find the maximum length subarray with unique elements <=2. K is 2 since its <=, the k< condition is not needed
    public int totalFruit(int[] fruits) {
        int i=0;
        int j=0;
        Map<Integer,Integer> fruitCount = new HashMap<Integer,Integer>();
        int max = 0;
        if(fruits.length<=2) return fruits.length;
        while(j<fruits.length){

            //add operation
            fruitCount.put(fruits[j],fruitCount.getOrDefault(fruits[j],0)+1);

            //redundant
            //if(fruitCount.size()<2){
            //    j++;
            //}
            if(fruitCount.size() <= 2){
                max = Math.max(max,j-i+1);
                j++;
            }
            else if(fruitCount.size() > 2 ){
                while(fruitCount.size() > 2){
                    fruitCount.put(fruits[i],fruitCount.get(fruits[i])-1);
                    if(fruitCount.get(fruits[i]) == 0){
                        fruitCount.remove(fruits[i]);
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}