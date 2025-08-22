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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return inorder(root,low,high);
    }
    public TreeNode inorder(TreeNode root,int low, int high){
        if(root==null) return root;
        if(root.val<low) return inorder(root.right,low,high);
        if(root.val>high) return inorder(root.left,low,high);
        root.left=inorder(root.left,low,high);
        root.right=inorder(root.right,low,high);
        return root;
          
    }
}