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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        if(root.left!=null && root.right!=null){
            TreeNode dummy=root.left;
            root.left=root.right;
            root.right=dummy;
        }
        else if(root.left==null){
            root.left=root.right;
            root.right=null;
        }
        else if(root.right==null){
            root.right=root.left;
            root.left=null;
        }
        return root;
    }
}