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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }  
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean end = false;
        
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            
            if (current == null) {
                end = true; // We have seen a null node
            } else {
                if (end) {
                    // If we have seen a null node before, and now we see a non-null node,
                    // it means the tree is not complete
                    return false;
                }
                q.offer(current.left);
                q.offer(current.right);    
            }
        }
        return true;
    }
}