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
    public int sumOfLeftLeaves(TreeNode root) {
        return check(root,false);
    }
    public static int check (TreeNode root,boolean isleft){
        if(root==null){
            return 0;
        }
        int sum=0;
        if(root.left==null && root.right==null){
            sum+=isleft?root.val :0;
        }
        return sum + check(root.left,true) + check(root.right,false);
    }
}