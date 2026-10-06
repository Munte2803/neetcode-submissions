class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=Arrays.stream(piles).max().getAsInt();
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            long time=0;
            for(int i=0;i<piles.length;i++){
                time+=Math.ceilDiv(piles[i],mid);
            }
            if(time<=h){
                hi=mid;
            }
            else if(time>h){
                lo=mid+1;
            }
            
        }
        return lo;


    }
}
