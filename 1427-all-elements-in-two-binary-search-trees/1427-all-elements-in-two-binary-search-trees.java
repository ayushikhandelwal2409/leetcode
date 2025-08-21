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
        ArrayList<Integer> ll=new ArrayList<>();
        // ArrayList<Integer> t1=new ArrayList<>();
        // ArrayList<Integer> t2=new ArrayList<>();
        inorder(root1,ll);
        inorder(root2,ll);
        // int i=0, j=0;
        // while(i<t1.size() && j<t2.size()){
        //     if(t1.get(i)<t2.get(j)){
        //         ll.add(t1.get(i));
        //         i++;
        //     }
        //     else{
        //         ll.add(t2.get(j));
        //         j++;
        //     }
        // }
        // while(i<t1.size()){
        //     ll.add(t1.get(i));
        // }
        // while(j<t2.size()){
        //     ll.add(t2.get(j));
        // }
        Collections.sort(ll);
        return ll;
    }
    public static void inorder(TreeNode root,ArrayList<Integer> ll){
        if(root==null) return ;
        inorder(root.left,ll);
        ll.add(root.val);
        inorder(root.right,ll);
    }
}