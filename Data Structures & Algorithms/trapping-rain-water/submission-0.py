class Solution:
    def trap(self, height: List[int]) -> int:
        pre=[0]*len(height)
        suf=[0]*len(height)
        for i in range(1,len(height)):
            pre[i] = max(pre[i-1], height[i-1])

            
        for i in range(len(height)-2,0,-1):
            suf[i]=max(suf[i+1],height[i+1])
        
        tot=0
        for i in range(len(height)):
            if min(pre[i],suf[i])-height[i]>0:
                tot+=min(pre[i],suf[i])-height[i]
        
        return tot


        