class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result=new HashSet<>();
        Arrays.sort(candidates);
        dfs(0,target,0,candidates,new ArrayList<>(),result);
        return new ArrayList<>(result);
    }
    public void dfs(int i, int target,int sum, int[] candidates, List<Integer> subset, Set<List<Integer>> result){
        if(sum!=target&&i>=candidates.length||sum>target){
            return;
        }
        if(sum==target){
            result.add(new ArrayList<>(subset));
            return;
        }
        if(sum+candidates[i]>target){
            return;
        }
        subset.add(candidates[i]);
        dfs(i+1,target,sum+candidates[i],candidates,subset,result);
        subset.removeLast();
        while(i+1<candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        dfs(i+1,target,sum,candidates,subset,result);
        

    }
    

}
