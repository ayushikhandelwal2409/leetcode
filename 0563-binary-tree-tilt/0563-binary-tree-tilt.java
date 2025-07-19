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
    int totaltilt = 0;
    public int findTilt(TreeNode root) {
        if(root==null){
            return 0;
        }

        tilt(root);
        return totaltilt;
    }
    public int tilt(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftsum=tilt(root.left);
        int rightsum=tilt(root.right);
        totaltilt+=Math.abs(leftsum-rightsum);
        return leftsum+rightsum+root.val;
    }
}