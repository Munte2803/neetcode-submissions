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
    private Map<Integer, Integer> pos = new HashMap<>();
    private int preIdx = 0;         

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            pos.put(inorder[i],i);
        }
        return build(preorder, 0, inorder.length - 1);

    }

    
    private TreeNode build(int[] preorder, int lo, int hi) {
        if (lo>hi) return null;                    
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int mid = pos.get(root.val);
        root.left = build(preorder,lo,mid-1);
        root.right = build(preorder,mid+1,hi);
        return root;
    }
}