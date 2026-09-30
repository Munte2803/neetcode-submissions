class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack=[]
        maxArea=0
        for i in range(len(heights)):  
            start = i          
            while len(stack)!=0 and stack[-1][1]>heights[i]:
                area=(i-stack[-1][0])*stack[-1][1]
                if area>maxArea:
                    maxArea=area
                start=stack[-1][0]
                stack.pop()
                
          
            stack.append((start,heights[i]))
            
            
        

        while len(stack)!=0:
            area=(len(heights)-stack[-1][0])*stack[-1][1]
            if area>maxArea:
                maxArea=area
            stack.pop()
            
            
        return maxArea
                
