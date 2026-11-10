class KthLargest {
    PriorityQueue<Integer> heap=new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        for(int i=0;i<nums.length;i++){
            this.heap.add(nums[i]);
            if(this.heap.size()>k){
                this.heap.poll();
            }

        }
        this.k=k;
    }
    
    public int add(int val) {
       this.heap.add(val);
       if(this.heap.size()>k){
        this.heap.poll();
       }
       return this.heap.peek();


    }
}
