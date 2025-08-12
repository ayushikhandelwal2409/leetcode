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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> k1=new ArrayList<>();
        ArrayList<Integer> k2=new ArrayList<>();
        traverse(root1,k1);
        traverse(root2,k2);
        return k1.equals(k2);
        
    }
    public static void traverse(TreeNode node,ArrayList<Integer> list){
        if(node!=null){
            if (node.left == null && node.right == null)
                list.add(node.val);
            traverse(node.left, list);
            traverse(node.right, list);
        }
    }
}