class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int slow1=0;
        while(slow!=slow1){
            slow=nums[slow];
            slow1=nums[slow1];
        }

        return slow;

        
    }
}
