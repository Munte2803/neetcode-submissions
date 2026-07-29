class Solution:
    def maxArea(self, heights: List[int]) -> int:
        i=0
        j=len(heights)-1
        maxwater=0
        while i<j:
            water=(j-i)*min(heights[i],heights[j])
            if water>maxwater:
                maxwater=water
            if heights[i]>heights[j]:
                j-=1
            elif heights[i]<heights[j]:
                i+=1
            else:
                j-=1
                i+=1
        return maxwater
            
            

         