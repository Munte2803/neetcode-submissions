class Solution {
    public int climbStairs(int n) {
        int[] cache=new int[n];
        return recursion(0,cache);

    }
    public int recursion(int i, int[] cache){
        if(i==cache.length){
            return 1;
        }
        if(i>cache.length){
            return 0;
        }

        if(cache[i]!=0){
            return cache[i];
        }
     
        cache[i]=recursion(i+1,cache)+recursion(i+2, cache);
        return cache[i];
        
    }
}
