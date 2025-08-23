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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<TreeNode> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        root=nodes(root,ans,set);
        if(root!=null){
            ans.add(root);
        }
        return ans;
    }
    public static TreeNode nodes(TreeNode root,ArrayList<TreeNode> ans, HashSet<Integer> set){
        if(root==null) return null;
        
        root.left=nodes(root.left,ans,set);
        root.right=nodes(root.right,ans,set);

        if(set.contains(root.val)){
            if(root.left!=null){ 
                ans.add(root.left);
            }
            if(root.right!=null){ 
                ans.add(root.right);
            }   

            return null;   
        }
        return root;
    }
}