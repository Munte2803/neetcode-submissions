class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<stones.length;i++){
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size()>1){
            int y=maxHeap.poll();
            int x=maxHeap.poll();
            if(x<y){
                maxHeap.add(y-x);
            }
        }
        if(maxHeap.size()!=0){
            return maxHeap.poll();
        }
        else{
            return 0;
        }
    }
}
