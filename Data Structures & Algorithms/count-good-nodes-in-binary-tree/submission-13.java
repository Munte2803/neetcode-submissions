/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int nr=0;  
    int max=-9999999;  
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        

        if(max<=root.val){
            max=root.val;
            nr++;
        }
        int nowMax=max;
        goodNodes(root.left);
        max=nowMax; 
        goodNodes(root.right);
        return nr;


        
    }
}
