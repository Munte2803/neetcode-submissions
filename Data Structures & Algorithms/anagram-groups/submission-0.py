class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        comp={}
        for i in range(len(strs)):
           frec = [0] * 26                              
           for char in strs[i]:   
             frec[ord(char) - ord('a')] += 1     
           cheie = tuple(frec) 
           comp.setdefault(cheie, []).append(strs[i])          

        return list(comp.values())


        

            
