class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (p, q) -> Integer.compare(q[0] * q[0] + q[1] * q[1], p[0] * p[0] + p[1] * p[1]));
        for(int i=0;i<points.length;i++){
            
            maxHeap.add(points[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();

            }
            
        }
        return maxHeap.toArray(new int[0][]);

    }
}
