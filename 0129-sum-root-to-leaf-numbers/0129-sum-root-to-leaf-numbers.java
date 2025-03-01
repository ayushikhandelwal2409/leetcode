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
    private int totalSum=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return totalSum;
    }
    public void dfs(TreeNode node, int currentNumber) {
        if (node == null) {
            return;
        }
        currentNumber = currentNumber * 10 + node.val;

        if (node.left == null && node.right == null) {
            totalSum += currentNumber; // Add the current number to the total sum
        } else {
            dfs(node.left, currentNumber);
            dfs(node.right, currentNumber);
        }
    }
}