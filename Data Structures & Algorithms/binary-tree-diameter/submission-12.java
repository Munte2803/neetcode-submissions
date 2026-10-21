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

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return (1+Math.max(maxDepth(root.left),maxDepth(root.right)));
        }
    
    int max=0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int d=maxDepth(root.left)+maxDepth(root.right);
        if(d>max){
            max=d;
        }
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        
        return max;
    
    }
}
