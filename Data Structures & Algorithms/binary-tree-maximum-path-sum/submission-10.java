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
    int best = Integer.MIN_VALUE;

public int maxPathSum(TreeNode root) {
    gain(root);
    return best;
}


private int gain(TreeNode node) {
    if (node == null) return 0;
    int left = Math.max(0, gain(node.left));     
    int right = Math.max(0, gain(node.right));     // la fel pentru dreapta
    best = Math.max(best, node.val+left+right);   // drumul care trece prin node, cu ambele ramuri
    return node.val+Math.max(left,right);                   // ce primește părintele: o singură ramură
}
}
