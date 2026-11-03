class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);        
        dfs(0,result,new ArrayList<>(),nums);
        return result;
    }
    public void dfs(int i,List<List<Integer>> result, List<Integer> subset, int [] nums){
        if(i>=nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }     
        subset.add(nums[i]);
        dfs(i+1,result,subset,nums); 

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
            
        subset.removeLast();
        dfs(i+1,result,subset,nums); 
            

    }
}
    


