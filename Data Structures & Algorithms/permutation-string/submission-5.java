class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;            
        }
        int[] counts1 = new int[26];
        int[] counts2 =new int[26];
        int l=-1;
        for(int i=0;i<s2.length();i++){
            
            counts2[s2.charAt(i)-'a']++;
            if(i<s1.length()){
                counts1[s1.charAt(i)-'a']++;
            }
            

              if(l<i-s1.length()){ 
                l++;             
                counts2[s2.charAt(l)-'a']--;
                
              }
            
            if(Arrays.equals(counts1, counts2)&&i>=s1.length()-1){
                return true;
            }
            
        }  
        return false;      
    }
}
