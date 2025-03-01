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
    private boolean check=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root,0,targetSum);
        return check;
    }
    public void dfs(TreeNode node, int sum,int targetSum) {
        if (node == null) {
            return;
        }
        sum +=  node.val;

        if (node.left == null && node.right == null  && sum==targetSum) {
           check=true ;
           return; // Add the current number to the total sum
        } else {
            dfs(node.left, sum,targetSum);
            dfs(node.right, sum,targetSum);
        }
    }
}    