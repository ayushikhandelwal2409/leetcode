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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> t1=new ArrayList<>();
        ArrayList<Integer> t2=new ArrayList<>();
        inorder(root1,t1);
        inorder(root2,t2);
        return merge(t1,t2);
    }
    public static void inorder(TreeNode root,ArrayList<Integer> ll){
        if(root==null) return ;
        inorder(root.left,ll);
        ll.add(root.val);
        inorder(root.right,ll);
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> t1,ArrayList<Integer> t2){
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0, j=0;
        while(i<t1.size() && j<t2.size()){
            if(t1.get(i)<t2.get(j)){
                ans.add(t1.get(i++));
            }
            else{
                ans.add(t2.get(j++));
            }
        }
        while(i<t1.size()){
            ans.add(t1.get(i++));
        }
        while(j<t2.size()){
            ans.add(t2.get(j++));
        }
        return ans;
    }
}