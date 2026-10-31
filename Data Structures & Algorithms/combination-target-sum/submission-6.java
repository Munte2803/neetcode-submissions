class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        dfs(0,nums.length,nums,target,0,result,subset);
        return result;
    }
    public void dfs(int i, int n,int[] nums, int target,int sum, List<List<Integer>> result, List<Integer> subset){
        if(sum!=target&&i>=n||sum>target){
            return;
        }
        if(sum==target){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i,n,nums,target,sum+nums[i],result,subset);
        subset.removeLast();
        dfs(i+1,n,nums,target,sum,result,subset);
    }
}
