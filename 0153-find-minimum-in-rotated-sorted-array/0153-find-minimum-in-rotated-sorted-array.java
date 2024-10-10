class Solution {
    public int findMin(int[] nums) {
        int n=6000;
        for(int num:nums){
            if(num<n)
                n=num;
        }
        return n;
    }
}