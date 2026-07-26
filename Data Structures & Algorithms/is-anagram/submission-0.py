class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        counts={}
        countt={}
        for x in s:
            counts[x]=counts.get(x,0) + 1
        for y in t:
            countt[y]=countt.get(y,0) + 1 

        if counts==countt:
            return True
        return False
