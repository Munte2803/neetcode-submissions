class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result=new ArrayList<>();
        boolean[] selected=new boolean[nums.length];
        dfs(new ArrayList<>(),result, nums,selected);
        return result;
    }
    public void dfs(List<Integer> subset,List<List<Integer>> result,int[] nums, boolean[] selected){        
            
        if(nums.length==subset.size()){
           result.add(new ArrayList<>(subset));
           return;
        }
        for(int i=0;i<nums.length;i++){
            if(selected[i]==false){
                subset.add(nums[i]);
                selected[i]=true;
                dfs(subset,result,nums,selected);
                subset.removeLast();
                selected[i]=false;
            }
        }


        
        
    }
}
