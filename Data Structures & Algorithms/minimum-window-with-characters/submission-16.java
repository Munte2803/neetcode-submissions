class Solution {
    public String minWindow(String s, String t) {
        int[] frecS=new int[128];
        int[] frecT=new int[128];
        int min=s.length();
        
        int l=0;
        int required=0;
        int formed=0;
        String substring="";        
        for(int i=0;i<t.length();i++){
            if (frecT[t.charAt(i)] == 0) required++;
            frecT[t.charAt(i)]++;
        }       
        for(int i=0;i<s.length();i++){
            frecS[s.charAt(i)]++;
            if(frecS[s.charAt(i)]==frecT[s.charAt(i)]){
                formed++;
            }
            while(formed==required){                                 
                if(frecT[s.charAt(l)]==frecS[s.charAt(l)]){
                    formed--; 
                    if(i-l+1<=min){
                        min=i-l+1;
                        substring=s.substring(l, i+1);
                }                   
                }
                frecS[s.charAt(l)]--;           
                
                l++;
            }
        }
        return substring;
        
    }
}
