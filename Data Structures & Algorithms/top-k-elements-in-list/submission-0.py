class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frec={}
        maxim=0
        bucket={}
        result=[]
        for x in nums:
           frec[x] = frec.get(x,0)+1
        

        for x, f in frec.items():             
          bucket.setdefault(f, []).append(x)

        result = []
        for f in range(len(nums), 0, -1):
         for x in bucket.get(f, []):
           result.append(x)
           if len(result) == k:
              return result
         


        
