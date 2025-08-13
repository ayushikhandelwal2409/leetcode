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
    int cam_count=0;
    public int minCameraCover(TreeNode root) {
        int c=minC(root);
        if(c==-1){
            cam_count++;
        }
        return cam_count;
    }
    public int minC(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=minC(root.left);
        int right=minC(root.right);
        if(left==-1 ||right==-1){//iss node pr camera ki need hai
            cam_count++;
            return 1;//camera lgwa dia
        }
        if(left==1 ||right==1){//inme se koi ek paas ya dono pr camera hai 
            return 0;//means m coverd hu
        }
        else{
            return -1; //need a caamera
        }

    }
}