class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        dfs(0,nums.length,subset,result,nums);
        return result;
    }
    void dfs(int i, int n, List<Integer> subset, List<List<Integer>> result,int[] nums){
        if(i>=n){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i+1,n,subset,result,nums);
        subset.removeLast();
        dfs(i+1,n,subset,result,nums);
        
    }
}
