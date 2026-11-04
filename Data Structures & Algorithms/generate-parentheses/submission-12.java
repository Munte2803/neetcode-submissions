class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n,new StringBuilder(),result,0);
        return result;

        
    }
    public void dfs(int n, StringBuilder subset, List<String> result, int balance){       
        if(balance<0){
            return;
        }
        if(subset.length()==2*n && balance!=0){
            return;
        }
        if(subset.length()==2*n && balance==0){
            result.add(subset.toString());
            return;
        }
        
        subset.append("(");
        balance++;
        dfs(n, subset, result, balance);
        subset.deleteCharAt(subset.length()-1);
        balance--;        
        subset.append(")");
        balance--;
        dfs(n, subset, result, balance);
        subset.deleteCharAt(subset.length()-1);





}
}
