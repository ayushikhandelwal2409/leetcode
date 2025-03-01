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
    private ArrayList<List<Integer>> l=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> ll=new ArrayList<>();
        dfs(root,0,targetSum,ll);
        return l;
    }
    public void dfs(TreeNode node, int sum,int targetSum,ArrayList<Integer> ll) {
        if (node == null) {
            return;
        }
        sum+=node.val;
        ll.add(node.val);
        if (node.left == null && node.right == null  && sum==targetSum) {
           l.add(new ArrayList<>(ll));
        } else {
            dfs(node.left, sum,targetSum,ll);
            dfs(node.right, sum,targetSum,ll);
        }
        ll.remove(ll.size()-1);
    }
} 