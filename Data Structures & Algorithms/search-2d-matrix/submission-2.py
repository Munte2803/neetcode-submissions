class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        lo=0
        hi=len(matrix)-1
        while lo<=hi:
          mid=(lo+hi)//2
          if matrix[mid][0]>target:
            hi=mid-1
          elif matrix[mid][len(matrix[mid])-1]<target:
            lo=mid+1
          else:
            lo=0
            hi=len(matrix[mid])-1
            while lo<=hi:
                mid1=(lo+hi)//2
                if matrix[mid][mid1]>target:
                    hi=mid1-1
                elif matrix[mid][mid1]<target:
                    lo=mid1+1
                else:
                    return True
            return False
        return False
            



        


    


        