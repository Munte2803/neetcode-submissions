class Solution:

    def encode(self, strs: List[str]) -> str:
        enc=''
        for string in strs:
            enc += str(len(string)) + "#" + string
        return enc


    def decode(self, s: str) -> List[str]:
        strs=[]
        i=0
        while i<len(s):
         j = s.find("#", i)
         n = int(s[i:j])
         strs.append(s[j+1:j+n+1])
         i=j+n+1
        return strs   

 