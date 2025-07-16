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
    public int getMinimumDifference(TreeNode root) {
        int minDiff=Integer.MAX_VALUE;
        ArrayList<Integer> list=new ArrayList<>();
        Inorder(root,list);
        for(int i=1;i<list.size();i++){
            minDiff=Math.min(minDiff,list.get(i)-list.get(i-1));
        }
        return minDiff;
    }
    public void Inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        Inorder(root.left,list);
        list.add(root.val);
        Inorder(root.right,list);
    }
}