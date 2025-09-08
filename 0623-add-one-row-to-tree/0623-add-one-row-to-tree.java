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
class Solution{
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null) return root;
        if(depth==1) {
            TreeNode newroot=new TreeNode(val);
            newroot.left=root;
            return newroot;
        }
        Queue<TreeNode> q=new LinkedList<>();
        int level=0;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            level++;
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(level==depth-1){
                    TreeNode tempLeft = node.left;
                    TreeNode tempRight = node.right;
                    TreeNode newLeft = new TreeNode(val);
                    TreeNode newRight = new TreeNode(val);
                    node.left = newLeft;
                    node.right = newRight;
                    newLeft.left = tempLeft;
                    newRight.right = tempRight;
                }
                else{
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);
                }
                
            }
        }
        return root;
    }
}