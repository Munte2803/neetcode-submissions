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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            if(queue.peek()!=null){
                list.add(queue.peek().val);
            }
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                                                    
            }
            
            
        }
        return list;
        
    }
}
