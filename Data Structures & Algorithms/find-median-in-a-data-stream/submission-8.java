class MedianFinder {

    public MedianFinder() {
        
    }
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
    
    
    public void addNum(int num) {
       if(minHeap.isEmpty()||num>minHeap.peek()){
            minHeap.add(num);
       }else{
            maxHeap.add(num);
       }
       if(minHeap.size()-maxHeap.size()>1){
            int x = minHeap.poll();
            maxHeap.add(x);
       }else if(maxHeap.size()-minHeap.size()>1){
            int x = maxHeap.poll();
            minHeap.add(x);
       }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }else if(minHeap.size()>maxHeap.size()){
            return minHeap.peek();
        }else{
            return maxHeap.peek();
        }
    }
}
