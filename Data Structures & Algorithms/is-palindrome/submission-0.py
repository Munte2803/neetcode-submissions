class Solution:
    def isPalindrome(self, s: str) -> bool:
        n=len(s)-1
        i=0
        while i<n:
            if not s[i].isalnum():
                i+=1
                continue
                       

            if not s[n].isalnum():
                n-=1
                continue

            if s[i].lower()!=s[n].lower():
                return False
            i+=1
            n-=1
        return True    
                  
                    



