class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency= new ArrayList<>();
        Set<Integer> verified=new HashSet<>();
        Set<Integer> path=new HashSet<>();
        List<Integer> order= new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            adjacency.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(dfs(i,adjacency,path,verified, order)==false)
                return new int[0];                
                              
        }
        int[] trueOrder=order.reversed().stream().mapToInt(Integer::intValue).toArray();
        return trueOrder;



    }
    public boolean dfs(int i, List<List<Integer>> adjacency, Set<Integer> path, Set<Integer> verified, List<Integer> order){

        if(verified.contains(i)){
            return true;
        }
    
        if(path.contains(i)){
            return false;
        }
        path.add(i);
        
        for(int j:adjacency.get(i)){
            if(dfs(j,adjacency,path,verified, order)==false){
                return false;
            }
            
        }
        path.remove(i);
        verified.add(i);
        order.add(i);
        
        return true;
        
        

        
        
    }
}
