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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int diam1=diameterOfBinaryTree(root.left);
        int diam2=diameterOfBinaryTree(root.right);
        int diam3=hi(root.left)+hi(root.right);
        int max=Math.max(Math.max(diam1,diam2),diam3);
        return max;
        
    }
    public static int hi(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=hi(root.left);
        int r=hi(root.right);
        int m=Math.max(l,r)+1;
        return m;
    }
}