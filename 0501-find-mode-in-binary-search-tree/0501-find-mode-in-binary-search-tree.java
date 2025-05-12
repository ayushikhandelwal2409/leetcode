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
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> l=new ArrayList<>();

        inorder(root, l);

        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for(int i: l){
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
            maxCount = Math.max(maxCount, count);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int k:map.keySet()){
            if(map.get(k)==maxCount){
                ans.add(k);
            }
        }
        int[] arr=ans.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
    public static void inorder(TreeNode root,ArrayList<Integer> l){
        if(root==null){
            return;
        }
        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);
    }
}