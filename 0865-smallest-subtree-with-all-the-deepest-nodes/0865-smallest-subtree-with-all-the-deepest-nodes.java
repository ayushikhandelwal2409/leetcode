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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).node;
    }
    private static class Pair {
        int depth;
        TreeNode node;
        
        Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
     private Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, null);
        }

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        if (left.depth == right.depth) {
            // Both sides have the same depth, current node is LCA of deepest nodes
            return new Pair(left.depth + 1, root);
        } else if (left.depth > right.depth) {
            // Left side is deeper
            return new Pair(left.depth + 1, left.node);
        } else {
            // Right side is deeper
            return new Pair(right.depth + 1, right.node);
        }
    }
}