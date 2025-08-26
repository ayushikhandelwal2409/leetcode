class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i:nums){
            sum+=i;
            min=Math.min(min,i);
        }
        return sum-(min*n);
    }
}