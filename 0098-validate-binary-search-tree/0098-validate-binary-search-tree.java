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
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean check(TreeNode node, long min, long max) {
        // Base case: an empty node is a valid BST
        if (node == null) {
            return true;
        }
        
        // Check if the current node's value is within the valid range
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        // Recursively check the left and right subtrees with updated ranges
        return check(node.left, min, node.val) && 
               check(node.right, node.val, max);
    }
}