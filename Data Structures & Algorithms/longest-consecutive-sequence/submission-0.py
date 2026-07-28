class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s=set(nums)
        best=0
        for x in s:
            if x-1 not in s:
                n=0
                while(x+n) in s:
                    n+=1
                best = max(best, n)
        return best