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
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); 
        }
        idx=postorder.length-1;
        return create(0, inorder.length - 1,postorder);
    }
    private TreeNode create(int start,int end,int[] postorder){
        if(start>end) return null;
        int value=postorder[idx];
        idx--;
        TreeNode root=new TreeNode(value);
        int inorder_idx=map.get(value);
        root.right = create(inorder_idx + 1, end, postorder);
        root.left = create(start, inorder_idx - 1, postorder);
        return root;
    }
}