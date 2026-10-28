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

public class Codec {

    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();  
    queue.add(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node == null) {
            sb.append("n,");                       
        } else {
            sb.append(node.val).append(",");       
            queue.add(node.left);
            queue.add(node.right);
        }
    }
    return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        if (nodes.length==0||nodes[0].equals("n")){
            return null;
        }
        int i=1;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode parent = queue.poll();

            if (!nodes[i].equals("n")) {
                parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(parent.left);
            }
            i++;
            if (!nodes[i].equals("n")) {
                parent.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(parent.right);
            }
            i++;
            
        }
        return root;
    }
}
