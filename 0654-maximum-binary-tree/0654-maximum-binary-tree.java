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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int l=nums.length-1;
        return construct(nums,0,l);
    }
    public static TreeNode construct(int[] nums,int i, int j){
        if(i>j){
            return null;
        }
        int index=getmax(nums,i,j);
        TreeNode root=new TreeNode(nums[index]);
        root.left=construct(nums,i,index-1);
        root.right=construct(nums,index+1,j);
        return root;
    }
    public static int getmax(int[] arr,int i,int j){
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int k=i;k<=j;k++){
            if(arr[k]>max){
                max=arr[k];
                index=k;
            }
        }
        return index;
    }
}