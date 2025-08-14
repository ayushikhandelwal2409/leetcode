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
    public boolean isEvenOddTree(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<TreeNode> k=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                k.add(node);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            list.add(new ArrayList<>(k));
        }
        return check(list);
    }
    public static boolean check(ArrayList<ArrayList<TreeNode>> list){
        int n=list.size();
        for(int i=0;i<n;i+=2){
            for(int j=0;j<list.get(i).size();j++){
                if(list.get(i).get(j).val%2==0) return false;
                if(j!=0){
                    if(list.get(i).get(j-1).val>=list.get(i).get(j).val) return false;
                }
            }
        }
        for(int i=1;i<n;i+=2){
            for(int j=0;j<list.get(i).size();j++){
                if(list.get(i).get(j).val%2!=0) return false;
                if(j!=0){
                    if(list.get(i).get(j-1).val<=list.get(i).get(j).val) return false;
                }
            }
        }
        return true;
    }
}