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
    int diff=0;
    public int maxAncestorDiff(TreeNode root) {
        find_diff(root,root.val,root.val);
        return diff;
        
    }
    public void find_diff(TreeNode root,int min,int max){
        if(root==null){
            return ;
        }
        max=Math.max(root.val,max);
        min=Math.min(root.val,min);
        int  diff2=Math.max(Math.abs(root.val-max),Math.abs(root.val-min));
        diff = Math.max(diff, diff2);
        find_diff(root.left,min,max);
        find_diff(root.right,min,max);
    }
}