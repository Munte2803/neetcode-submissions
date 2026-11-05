class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        dfs(0,0,new ArrayList<>(),result,s);
        return result;
    }
    public void dfs(int i,int j, List<String> subset, List<List<String>> result, String s){
        if(j==s.length()){
            result.add(new ArrayList<>(subset));
            return;
        }
        if(i==s.length()){
            return;
        }

        StringBuilder sb=new StringBuilder(s.substring(j,i+1));
        if(sb.toString().equals(sb.reverse().toString())&&sb.length()!=0){
            subset.add(sb.toString());
            dfs(i,i+1,subset,result,s);
            subset.removeLast();
        }
        
        dfs(i+1,j,subset,result,s);   
        


    }
}
