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
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }
    private int checkBalance(TreeNode node) {
        if (node == null) {
            return 0; // Height of an empty tree is 0
        }
        // Check the height of left subtree
        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is not balanced
        }
        // Check the height of right subtree
        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is not balanced
        }
        // Check if the current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }
        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}