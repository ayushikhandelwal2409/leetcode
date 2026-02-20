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
    ArrayList<TreeNode> ll=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        int n=ll.size();
        return buildtree(0,n-1);
      //  Node mainroot=new TreeNode(ll.get(n/2+1).val);
    }
    public TreeNode buildtree(int l,int r){
        if(l>r){
            return null;
        }
        int mid=(l+r)/2;
        TreeNode root=new TreeNode(ll.get(mid).val);
        root.left=buildtree(l,mid-1);
        root.right=buildtree(mid+1,r);
        return root;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        ll.add(root);
        inorder(root.right);
    }
}