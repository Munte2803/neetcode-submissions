class Solution {

    public int characterReplacement(String s, int k) {
        int longest=0;
        Map<Character,Integer> apparitions=new HashMap<>();
        int maxCount=0;
        int nr=0;
        for(int i=0;i<s.length();i++){
            apparitions.merge(s.charAt(i), 1, Integer::sum);
            if(apparitions.get(s.charAt(i))>maxCount){
                maxCount=apparitions.get(s.charAt(i));
            }
            
           
            while(i-nr+1-maxCount>k){
                
                apparitions.merge(s.charAt(nr),-1, Integer::sum);
                nr++;
                
            }
           
                longest=Math.max(longest,i-nr+1);
            

        }
        return longest;
               
    }
}
