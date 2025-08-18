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
    public static void inorder(ArrayList<TreeNode>ans,TreeNode root){
        if(root==null){
            return;
        }
        inorder(ans,root.left);
        ans.add(root);
        inorder(ans,root.right);
    }
    public static TreeNode tree(ArrayList<TreeNode>ans,int i){
        if(i==ans.size()){
            return null;
        }
        TreeNode root=ans.get(i);
        root.left=null;
        root.right=tree(ans,i+1);
        return root;
    }
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode>ans=new ArrayList<>();
        inorder(ans,root);
        return tree(ans,0);
    }
}