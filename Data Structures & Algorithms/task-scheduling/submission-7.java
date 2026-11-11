class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        int nr=0;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
        Deque<int[]> queue=new ArrayDeque<>();
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                maxHeap.add(freq[i]);
            }
        }
        while(!maxHeap.isEmpty()||!queue.isEmpty()){
            nr++;
            if(!maxHeap.isEmpty()){
                int element=maxHeap.poll();
                element--;
                if(element>0){
                queue.addLast(new int[]{element,nr+n});
            }
            }        
            
            
            if(!queue.isEmpty()&&nr>=queue.getFirst()[1]){
                maxHeap.add(queue.getFirst()[0]);
                queue.pollFirst();
            }

            
        }

        return nr;
    }
}
