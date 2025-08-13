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
    int moves=0;
    public int distributeCoins(TreeNode root) {
        minmove(root);
        return moves;
        
    }
    public int minmove(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=minmove(root.left);
        int right=minmove(root.right);
        moves=moves+Math.abs(left)+Math.abs(right);
        return root.val+left+right-1;

    }
}