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
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); 
        }
        int n=preorder.length;
        return create(0,n-1,map,preorder);
    }
    public  TreeNode create(int start,int end,HashMap<Integer,Integer> map,int[] preorder){
        if(start>end) return null;
        int value=preorder[idx];
        idx++;
        TreeNode root=new TreeNode(value);
        int inorder_idx=map.get(value);
        root.left=create(start,inorder_idx-1,map,preorder);
        root.right=create(inorder_idx+1,end,map,preorder);
        return root;
    }
}