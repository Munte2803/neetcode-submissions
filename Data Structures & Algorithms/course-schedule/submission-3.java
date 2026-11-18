class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency= new ArrayList<>();
        Set<Integer> verificate=new HashSet<>();
        for(int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());                    
        }
        for(int[] edge:prerequisites){
            
            adjacency.get(edge[1]).add(edge[0]);            

                
        }  
        for(int i=0;i<numCourses;i++){
            if(dfs(i,adjacency,new HashSet<>(), verificate)==false){
                return false;
            }                    
        }
        return true;

    }
    public boolean dfs(int i, List<List<Integer>> adjacency, Set<Integer> path, Set<Integer> verified){

        if(verified.contains(i)){
            return true;
        }
    
        if(path.contains(i)){
            return false;
        }
        path.add(i);
        
        for(int j:adjacency.get(i)){
            if(dfs(j,adjacency,path,verified)==false){
                return false;
            }
            
        }
        verified.add(i);
        return true;
        
        

        
        
    }
}
