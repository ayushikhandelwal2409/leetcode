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
    //private ArrayList<List<Integer>> l=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ll=new ArrayList<>();
        dfs(root,ll,"");
        return ll;
    }
    public void dfs(TreeNode node,ArrayList<String> ll,String ans) {
        if (node == null) {
            return;
        }
        ans+= Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            ll.add(ans);
        } else {
            ans+="->";
            dfs(node.left,ll,ans);
            dfs(node.right,ll,ans);
        }
    }
}