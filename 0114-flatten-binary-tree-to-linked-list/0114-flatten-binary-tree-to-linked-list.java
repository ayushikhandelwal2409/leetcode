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
    public void flatten(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        insert(root, q);
        q.poll();// Removing the root from the queue so that the elment poll from queue add as right element of that root
        while (!q.isEmpty()) {
            root.right = q.poll();
            root.left = null;     
            root = root.right;
        }
    }
    void insert(TreeNode node, Queue<TreeNode> queue) {  //pre order traversal to add nodes in queue
        if (node == null) return;
        queue.add(node);
        insert(node.left, queue);
        insert(node.right, queue);
    }
}