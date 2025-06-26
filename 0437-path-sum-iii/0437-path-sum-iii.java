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
    private int no_of_paths=0;
    private HashMap<Long, Integer> prefixSumCount = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        prefixSumCount.put(0L,1);
        count(root,targetSum,0L);
        return no_of_paths;
    }
    public void count(TreeNode node, int targetSum,Long cursum){
        if(node==null) return;
        cursum+=node.val;
        if(prefixSumCount.containsKey(cursum-targetSum)){
            no_of_paths+=prefixSumCount.get(cursum-targetSum);
        }
        prefixSumCount.put(cursum,prefixSumCount.getOrDefault(cursum,0)+1);
        count(node.left,targetSum,cursum);
        count(node.right,targetSum,cursum);
        prefixSumCount.put(cursum,prefixSumCount.getOrDefault(cursum,0)-1);
    }
}